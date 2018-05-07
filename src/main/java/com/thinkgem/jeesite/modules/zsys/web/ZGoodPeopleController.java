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
import com.thinkgem.jeesite.modules.zsys.entity.ZGoodPeople;
import com.thinkgem.jeesite.modules.zsys.service.ZGoodPeopleService;

/**
 * 好人好事Controller
 * @author 好人好事
 * @version 2018-01-25
 */
@Controller
@RequestMapping(value = "${adminPath}/zsys/zGoodPeople")
public class ZGoodPeopleController extends BaseController {

	@Autowired
	private ZGoodPeopleService zGoodPeopleService;
	
	@ModelAttribute
	public ZGoodPeople get(@RequestParam(required=false) String id) {
		ZGoodPeople entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zGoodPeopleService.get(id);
		}
		if (entity == null){
			entity = new ZGoodPeople();
		}
		return entity;
	}
	
	@RequiresPermissions("zsys:zGoodPeople:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZGoodPeople zGoodPeople, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZGoodPeople> page = zGoodPeopleService.findPage(new Page<ZGoodPeople>(request, response), zGoodPeople); 
		model.addAttribute("page", page);
		model.addAttribute("zGoodPeople", zGoodPeople);
		
		return "modules/zsys/zGoodPeopleList";
	}

	@RequiresPermissions("zsys:zGoodPeople:view")
	@RequestMapping(value = "form")
	public String form(ZGoodPeople zGoodPeople, Model model) {
		model.addAttribute("zGoodPeople", zGoodPeople);
		return "modules/zsys/zGoodPeopleForm";
	}

	@RequiresPermissions("zsys:zGoodPeople:edit")
	@RequestMapping(value = "save")
	public String save(ZGoodPeople zGoodPeople, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zGoodPeople)){
			return form(zGoodPeople, model);
		}
		zGoodPeopleService.save(zGoodPeople);
		addMessage(redirectAttributes, "保存好人好事成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zGoodPeople/?repage";
	}
	
	@RequiresPermissions("zsys:zGoodPeople:edit")
	@RequestMapping(value = "delete")
	public String delete(ZGoodPeople zGoodPeople, RedirectAttributes redirectAttributes) {
		zGoodPeopleService.delete(zGoodPeople);
		addMessage(redirectAttributes, "删除好人好事成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zGoodPeople/?repage";
	}

}