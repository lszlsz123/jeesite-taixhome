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
import com.thinkgem.jeesite.modules.zsys.entity.ZVehicleInsurance;
import com.thinkgem.jeesite.modules.zsys.service.ZVehicleInsuranceService;

/**
 * 车辆投保情况查询Controller
 * @author tom
 * @version 2017-12-17
 */
@Controller
@RequestMapping(value = "${adminPath}/zsys/zVehicleInsurance")
public class ZVehicleInsuranceController extends BaseController {

	@Autowired
	private ZVehicleInsuranceService zVehicleInsuranceService;
	
	@ModelAttribute
	public ZVehicleInsurance get(@RequestParam(required=false) String id) {
		ZVehicleInsurance entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zVehicleInsuranceService.get(id);
		}
		if (entity == null){
			entity = new ZVehicleInsurance();
		}
		return entity;
	}
	
	@RequiresPermissions("zsys:zVehicleInsurance:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZVehicleInsurance zVehicleInsurance, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZVehicleInsurance> page = zVehicleInsuranceService.findPage(new Page<ZVehicleInsurance>(request, response), zVehicleInsurance); 
		model.addAttribute("page", page);
		model.addAttribute("zVehicleInsurance", zVehicleInsurance);
		
		return "modules/zsys/zVehicleInsuranceList";
	}

	@RequiresPermissions("zsys:zVehicleInsurance:view")
	@RequestMapping(value = "form")
	public String form(ZVehicleInsurance zVehicleInsurance, Model model) {
		model.addAttribute("zVehicleInsurance", zVehicleInsurance);
		return "modules/zsys/zVehicleInsuranceForm";
	}

	@RequiresPermissions("zsys:zVehicleInsurance:edit")
	@RequestMapping(value = "save")
	public String save(ZVehicleInsurance zVehicleInsurance, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zVehicleInsurance)){
			return form(zVehicleInsurance, model);
		}
		zVehicleInsuranceService.save(zVehicleInsurance);
		addMessage(redirectAttributes, "保存车辆投保情况查询成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zVehicleInsurance/?repage";
	}
	
	@RequiresPermissions("zsys:zVehicleInsurance:edit")
	@RequestMapping(value = "delete")
	public String delete(ZVehicleInsurance zVehicleInsurance, RedirectAttributes redirectAttributes) {
		zVehicleInsuranceService.delete(zVehicleInsurance);
		addMessage(redirectAttributes, "删除车辆投保情况查询成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zVehicleInsurance/?repage";
	}

}