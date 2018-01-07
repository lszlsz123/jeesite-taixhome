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
import com.thinkgem.jeesite.modules.zsys.entity.ZMakeUpLoss;
import com.thinkgem.jeesite.modules.zsys.service.ZMakeUpLossService;

/**
 * 证件遗失补办业务Controller
 * @author tom
 * @version 2018-01-02
 */
@Controller
@RequestMapping(value = "${adminPath}/zsys/zMakeUpLoss")
public class ZMakeUpLossController extends BaseController {

	@Autowired
	private ZMakeUpLossService zMakeUpLossService;
	
	@ModelAttribute
	public ZMakeUpLoss get(@RequestParam(required=false) String id) {
		ZMakeUpLoss entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zMakeUpLossService.get(id);
		}
		if (entity == null){
			entity = new ZMakeUpLoss();
		}
		return entity;
	}
	
	@RequiresPermissions("zsys:zMakeUpLoss:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZMakeUpLoss zMakeUpLoss, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZMakeUpLoss> page = zMakeUpLossService.findPage(new Page<ZMakeUpLoss>(request, response), zMakeUpLoss); 
		model.addAttribute("page", page);
		model.addAttribute("zMakeUpLoss", zMakeUpLoss);
		
		return "modules/zsys/zMakeUpLossList";
	}

	@RequiresPermissions("zsys:zMakeUpLoss:view")
	@RequestMapping(value = "form")
	public String form(ZMakeUpLoss zMakeUpLoss, Model model) {
		model.addAttribute("zMakeUpLoss", zMakeUpLoss);
		return "modules/zsys/zMakeUpLossForm";
	}

	@RequiresPermissions("zsys:zMakeUpLoss:edit")
	@RequestMapping(value = "save")
	public String save(ZMakeUpLoss zMakeUpLoss, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zMakeUpLoss)){
			return form(zMakeUpLoss, model);
		}
		zMakeUpLossService.save(zMakeUpLoss);
		addMessage(redirectAttributes, "保存证件遗失补办业务成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zMakeUpLoss/?repage";
	}
	
	@RequiresPermissions("zsys:zMakeUpLoss:edit")
	@RequestMapping(value = "delete")
	public String delete(ZMakeUpLoss zMakeUpLoss, RedirectAttributes redirectAttributes) {
		zMakeUpLossService.delete(zMakeUpLoss);
		addMessage(redirectAttributes, "删除证件遗失补办业务成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zMakeUpLoss/?repage";
	}

}