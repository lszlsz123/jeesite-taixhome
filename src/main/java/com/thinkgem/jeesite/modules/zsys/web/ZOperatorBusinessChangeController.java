/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.web;

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
import com.thinkgem.jeesite.modules.zsys.entity.ZOperatorBusinessChange;
import com.thinkgem.jeesite.modules.zsys.service.ZOperatorBusinessChangeService;

/**
 * 责任经营者变更业务办理查询Controller
 * @author tom
 * @version 2017-12-14
 */
@Controller
@RequestMapping(value = "${adminPath}/zsys/zOperatorBusinessChange")
public class ZOperatorBusinessChangeController extends BaseController {

	@Autowired
	private ZOperatorBusinessChangeService zOperatorBusinessChangeService;
	
	@ModelAttribute
	public ZOperatorBusinessChange get(@RequestParam(required=false) String id) {
		ZOperatorBusinessChange entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zOperatorBusinessChangeService.get(id);
		}
		if (entity == null){
			entity = new ZOperatorBusinessChange();
		}
		return entity;
	}
	
	@RequiresPermissions("zsys:zOperatorBusinessChange:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZOperatorBusinessChange zOperatorBusinessChange, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZOperatorBusinessChange> page = zOperatorBusinessChangeService.findPage(new Page<ZOperatorBusinessChange>(request, response), zOperatorBusinessChange); 
		model.addAttribute("page", page);
		model.addAttribute("zOperatorBusinessChange", zOperatorBusinessChange);
		
		return "modules/zsys/zOperatorBusinessChangeList";
	}

	@RequiresPermissions("zsys:zOperatorBusinessChange:view")
	@RequestMapping(value = "form")
	public String form(ZOperatorBusinessChange zOperatorBusinessChange, Model model) {
		model.addAttribute("zOperatorBusinessChange", zOperatorBusinessChange);
		return "modules/zsys/zOperatorBusinessChangeForm";
	}

	@RequiresPermissions("zsys:zOperatorBusinessChange:edit")
	@RequestMapping(value = "save")
	public String save(ZOperatorBusinessChange zOperatorBusinessChange, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zOperatorBusinessChange)){
			return form(zOperatorBusinessChange, model);
		}
		zOperatorBusinessChangeService.save(zOperatorBusinessChange);
		addMessage(redirectAttributes, "保存责任经营者变更业务办理查询成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zOperatorBusinessChange/?repage";
	}
	
	@RequiresPermissions("zsys:zOperatorBusinessChange:edit")
	@RequestMapping(value = "delete")
	public String delete(ZOperatorBusinessChange zOperatorBusinessChange, RedirectAttributes redirectAttributes) {
		zOperatorBusinessChangeService.delete(zOperatorBusinessChange);
		addMessage(redirectAttributes, "删除责任经营者变更业务办理查询成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zOperatorBusinessChange/?repage";
	}

}