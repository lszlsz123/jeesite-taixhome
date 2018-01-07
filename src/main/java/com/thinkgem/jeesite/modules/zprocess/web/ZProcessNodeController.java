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
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessNode;
import com.thinkgem.jeesite.modules.zprocess.service.ZProcessNodeService;

/**
 * 流程节点管理Controller
 * @author tom
 * @version 2018-01-07
 */
@Controller
@RequestMapping(value = "${adminPath}/zprocess/zProcessNode")
public class ZProcessNodeController extends BaseController {

	@Autowired
	private ZProcessNodeService zProcessNodeService;
	
	@ModelAttribute
	public ZProcessNode get(@RequestParam(required=false) String id) {
		ZProcessNode entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zProcessNodeService.get(id);
		}
		if (entity == null){
			entity = new ZProcessNode();
		}
		return entity;
	}
	
	@RequiresPermissions("zprocess:zProcessNode:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZProcessNode zProcessNode, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZProcessNode> page = zProcessNodeService.findPage(new Page<ZProcessNode>(request, response), zProcessNode); 
		model.addAttribute("page", page);
		model.addAttribute("zProcessNode", zProcessNode);
		
		return "modules/zprocess/zProcessNodeList";
	}

	@RequiresPermissions("zprocess:zProcessNode:view")
	@RequestMapping(value = "form")
	public String form(ZProcessNode zProcessNode, Model model) {
		model.addAttribute("zProcessNode", zProcessNode);
		return "modules/zprocess/zProcessNodeForm";
	}

	@RequiresPermissions("zprocess:zProcessNode:edit")
	@RequestMapping(value = "save")
	public String save(ZProcessNode zProcessNode, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zProcessNode)){
			return form(zProcessNode, model);
		}
		zProcessNodeService.save(zProcessNode);
		addMessage(redirectAttributes, "保存流程节点管理成功");
		return "redirect:"+Global.getAdminPath()+"/zprocess/zProcessNode/?repage";
	}
	
	@RequiresPermissions("zprocess:zProcessNode:edit")
	@RequestMapping(value = "delete")
	public String delete(ZProcessNode zProcessNode, RedirectAttributes redirectAttributes) {
		zProcessNodeService.delete(zProcessNode);
		addMessage(redirectAttributes, "删除流程节点管理成功");
		return "redirect:"+Global.getAdminPath()+"/zprocess/zProcessNode/?repage";
	}

}