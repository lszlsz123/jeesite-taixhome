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
import com.thinkgem.jeesite.modules.zsys.entity.ZInsuranceClaimSettlement;
import com.thinkgem.jeesite.modules.zsys.service.ZInsuranceClaimSettlementService;

/**
 * 保险理赔业务查询Controller
 * @author tom
 * @version 2017-12-17
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zInsuranceClaimSettlement")
public class ZInsuranceClaimSettlementFrontController extends BaseController {

	@Autowired
	private ZInsuranceClaimSettlementService zInsuranceClaimSettlementService;
	
	@ModelAttribute
	public ZInsuranceClaimSettlement get(@RequestParam(required=false) String id) {
		ZInsuranceClaimSettlement entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zInsuranceClaimSettlementService.get(id);
		}
		if (entity == null){
			entity = new ZInsuranceClaimSettlement();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ZInsuranceClaimSettlement zInsuranceClaimSettlement, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZInsuranceClaimSettlement> page = zInsuranceClaimSettlementService.findPage(new Page<ZInsuranceClaimSettlement>(request, response), zInsuranceClaimSettlement); 
		model.addAttribute("page", page);
		model.addAttribute("zInsuranceClaimSettlement", zInsuranceClaimSettlement);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zInsuranceClaimSettlementList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZInsuranceClaimSettlement zInsuranceClaimSettlement, HttpServletRequest request, HttpServletResponse response, Model model) {
		zInsuranceClaimSettlement = get(zInsuranceClaimSettlement.getId());
		model.addAttribute("zInsuranceClaimSettlement", zInsuranceClaimSettlement);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zInsuranceClaimSettlementForm";
	}

}