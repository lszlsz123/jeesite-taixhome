/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessStep;
import com.thinkgem.jeesite.modules.zprocess.service.ZProcessStepService;

/**
 * 流程操作节点记录Controller
 * @author tom
 * @version 2017-12-24
 */
@Controller
@RequestMapping(value = "${frontPath}/zprocess/zProcessStep")
public class ZProcessStepFrontController extends BaseController {

	@Autowired
	private ZProcessStepService zProcessStepService;
	
	@ModelAttribute
	public ZProcessStep get(@RequestParam(required=false) String id) {
		ZProcessStep entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zProcessStepService.get(id);
		}
		if (entity == null){
			entity = new ZProcessStep();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ZProcessStep zProcessStep, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZProcessStep> page = zProcessStepService.findPage(new Page<ZProcessStep>(request, response), zProcessStep); 
		model.addAttribute("page", page);
		model.addAttribute("zProcessStep", zProcessStep);
		
		return "modules/cms/front/themes/taixhome/actionPage/zprocess/zProcessStepList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZProcessStep zProcessStep, HttpServletRequest request, HttpServletResponse response, Model model) {
		zProcessStep = get(zProcessStep.getId());
		model.addAttribute("zProcessStep", zProcessStep);
		return "modules/cms/front/themes/taixhome/actionPage/zprocess/zProcessStepForm";
	}

}