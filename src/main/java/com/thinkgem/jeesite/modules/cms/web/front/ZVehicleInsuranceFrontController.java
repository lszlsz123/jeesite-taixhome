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
import com.thinkgem.jeesite.modules.zsys.entity.ZVehicleInsurance;
import com.thinkgem.jeesite.modules.zsys.service.ZVehicleInsuranceService;

/**
 * 车辆投保情况查询Controller
 * @author tom
 * @version 2017-12-17
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zVehicleInsurance")
public class ZVehicleInsuranceFrontController extends BaseController {

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
	
	@RequestMapping(value = {"list", ""})
	public String list(ZVehicleInsurance zVehicleInsurance, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZVehicleInsurance> page = zVehicleInsuranceService.findPage(new Page<ZVehicleInsurance>(request, response), zVehicleInsurance); 
		model.addAttribute("page", page);
		model.addAttribute("zVehicleInsurance", zVehicleInsurance);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zVehicleInsuranceList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZVehicleInsurance zVehicleInsurance, HttpServletRequest request, HttpServletResponse response, Model model) {
		zVehicleInsurance = get(zVehicleInsurance.getId());
		model.addAttribute("zVehicleInsurance", zVehicleInsurance);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zVehicleInsuranceForm";
	}

}