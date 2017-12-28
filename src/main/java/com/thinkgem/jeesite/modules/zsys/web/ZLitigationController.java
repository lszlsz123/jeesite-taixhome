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
import com.thinkgem.jeesite.modules.zsys.entity.ZLitigation;
import com.thinkgem.jeesite.modules.zsys.service.ZLitigationService;

/**
 * 诉讼案件查询Controller
 * @author tom
 * @version 2017-12-17
 */
@Controller
@RequestMapping(value = "${adminPath}/zsys/zLitigation")
public class ZLitigationController extends BaseController {

	@Autowired
	private ZLitigationService zLitigationService;
	
	@ModelAttribute
	public ZLitigation get(@RequestParam(required=false) String id) {
		ZLitigation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zLitigationService.get(id);
		}
		if (entity == null){
			entity = new ZLitigation();
		}
		return entity;
	}
	
	@RequiresPermissions("zsys:zLitigation:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZLitigation zLitigation, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZLitigation> page = zLitigationService.findPage(new Page<ZLitigation>(request, response), zLitigation); 
		model.addAttribute("page", page);
		model.addAttribute("zLitigation", zLitigation);
		
		return "modules/zsys/zLitigationList";
	}

	@RequiresPermissions("zsys:zLitigation:view")
	@RequestMapping(value = "form")
	public String form(ZLitigation zLitigation, Model model) {
		model.addAttribute("zLitigation", zLitigation);
		return "modules/zsys/zLitigationForm";
	}

	@RequiresPermissions("zsys:zLitigation:edit")
	@RequestMapping(value = "save")
	public String save(ZLitigation zLitigation, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zLitigation)){
			return form(zLitigation, model);
		}
		zLitigationService.save(zLitigation);
		addMessage(redirectAttributes, "保存诉讼案件查询成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zLitigation/?repage";
	}
	
	@RequiresPermissions("zsys:zLitigation:edit")
	@RequestMapping(value = "delete")
	public String delete(ZLitigation zLitigation, RedirectAttributes redirectAttributes) {
		zLitigationService.delete(zLitigation);
		addMessage(redirectAttributes, "删除诉讼案件查询成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zLitigation/?repage";
	}

}