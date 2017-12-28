/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.web;

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
@RequestMapping(value = "${adminPath}/zprocess/zProcessStep")
public class ZProcessStepController extends BaseController {

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
	
	@RequiresPermissions("zprocess:zProcessStep:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZProcessStep zProcessStep, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZProcessStep> page = zProcessStepService.findPage(new Page<ZProcessStep>(request, response), zProcessStep); 
		model.addAttribute("page", page);
		model.addAttribute("zProcessStep", zProcessStep);
		
		return "modules/zprocess/zProcessStepList";
	}

	@RequiresPermissions("zprocess:zProcessStep:view")
	@RequestMapping(value = "form")
	public String form(ZProcessStep zProcessStep, Model model) {
		model.addAttribute("zProcessStep", zProcessStep);
		return "modules/zprocess/zProcessStepForm";
	}

	@RequiresPermissions("zprocess:zProcessStep:edit")
	@RequestMapping(value = "save")
	public String save(ZProcessStep zProcessStep, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zProcessStep)){
			return form(zProcessStep, model);
		}
		zProcessStepService.save(zProcessStep);
		addMessage(redirectAttributes, "保存流程操作节点记录成功");
		return "redirect:"+Global.getAdminPath()+"/zprocess/zProcessStep/?repage";
	}
	
	@RequiresPermissions("zprocess:zProcessStep:edit")
	@RequestMapping(value = "delete")
	public String delete(ZProcessStep zProcessStep, RedirectAttributes redirectAttributes) {
		zProcessStepService.delete(zProcessStep);
		addMessage(redirectAttributes, "删除流程操作节点记录成功");
		return "redirect:"+Global.getAdminPath()+"/zprocess/zProcessStep/?repage";
	}

}