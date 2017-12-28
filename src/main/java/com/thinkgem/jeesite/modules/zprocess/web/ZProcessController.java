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
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcess;
import com.thinkgem.jeesite.modules.zprocess.service.ZProcessService;

/**
 * 流程管理Controller
 * @author tom
 * @version 2017-12-24
 */
@Controller
@RequestMapping(value = "${adminPath}/zprocess/zProcess")
public class ZProcessController extends BaseController {

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
	
	@RequiresPermissions("zprocess:zProcess:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZProcess zProcess, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZProcess> page = zProcessService.findPage(new Page<ZProcess>(request, response), zProcess); 
		model.addAttribute("page", page);
		model.addAttribute("zProcess", zProcess);
		
		return "modules/zprocess/zProcessList";
	}

	@RequiresPermissions("zprocess:zProcess:view")
	@RequestMapping(value = "form")
	public String form(ZProcess zProcess, Model model) {
		model.addAttribute("zProcess", zProcess);
		return "modules/zprocess/zProcessForm";
	}

	@RequiresPermissions("zprocess:zProcess:edit")
	@RequestMapping(value = "save")
	public String save(ZProcess zProcess, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zProcess)){
			return form(zProcess, model);
		}
		zProcessService.save(zProcess);
		addMessage(redirectAttributes, "保存流程管理成功");
		return "redirect:"+Global.getAdminPath()+"/zprocess/zProcess/?repage";
	}
	
	@RequiresPermissions("zprocess:zProcess:edit")
	@RequestMapping(value = "delete")
	public String delete(ZProcess zProcess, RedirectAttributes redirectAttributes) {
		zProcessService.delete(zProcess);
		addMessage(redirectAttributes, "删除流程管理成功");
		return "redirect:"+Global.getAdminPath()+"/zprocess/zProcess/?repage";
	}

}