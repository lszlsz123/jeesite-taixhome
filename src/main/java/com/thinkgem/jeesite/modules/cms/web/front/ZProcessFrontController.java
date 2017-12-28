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
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcess;
import com.thinkgem.jeesite.modules.zprocess.service.ZProcessService;

/**
 * 流程管理Controller
 * @author tom
 * @version 2017-12-24
 */
@Controller
@RequestMapping(value = "${frontPath}/zprocess/zProcess")
public class ZProcessFrontController extends BaseController {

	@Autowired
	private ZProcessService zProcessService;
	
	@ModelAttribute
	public ZProcess get(@RequestParam(required=false) String id) {
		ZProcess entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zProcessService.get(id);
		}
		if (entity == null){
			entity = new ZProcess();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ZProcess zProcess, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZProcess> page = zProcessService.findPage(new Page<ZProcess>(request, response), zProcess); 
		model.addAttribute("page", page);
		model.addAttribute("zProcess", zProcess);
		
		return "modules/cms/front/themes/taixhome/actionPage/zprocess/zProcessList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZProcess zProcess, HttpServletRequest request, HttpServletResponse response, Model model) {
		zProcess = get(zProcess.getId());
		model.addAttribute("zProcess", zProcess);
		return "modules/cms/front/themes/taixhome/actionPage/zprocess/zProcessForm";
	}

}