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
import com.thinkgem.jeesite.modules.zsys.entity.ZInsuranceClaimSettlement;
import com.thinkgem.jeesite.modules.zsys.service.ZInsuranceClaimSettlementService;

/**
 * 保险理赔业务查询Controller
 * @author tom
 * @version 2017-12-17
 */
@Controller
@RequestMapping(value = "${adminPath}/zsys/zInsuranceClaimSettlement")
public class ZInsuranceClaimSettlementController extends BaseController {

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
	
	@RequiresPermissions("zsys:zInsuranceClaimSettlement:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZInsuranceClaimSettlement zInsuranceClaimSettlement, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZInsuranceClaimSettlement> page = zInsuranceClaimSettlementService.findPage(new Page<ZInsuranceClaimSettlement>(request, response), zInsuranceClaimSettlement); 
		model.addAttribute("page", page);
		model.addAttribute("zInsuranceClaimSettlement", zInsuranceClaimSettlement);
		
		return "modules/zsys/zInsuranceClaimSettlementList";
	}

	@RequiresPermissions("zsys:zInsuranceClaimSettlement:view")
	@RequestMapping(value = "form")
	public String form(ZInsuranceClaimSettlement zInsuranceClaimSettlement, Model model) {
		model.addAttribute("zInsuranceClaimSettlement", zInsuranceClaimSettlement);
		return "modules/zsys/zInsuranceClaimSettlementForm";
	}

	@RequiresPermissions("zsys:zInsuranceClaimSettlement:edit")
	@RequestMapping(value = "save")
	public String save(ZInsuranceClaimSettlement zInsuranceClaimSettlement, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zInsuranceClaimSettlement)){
			return form(zInsuranceClaimSettlement, model);
		}
		zInsuranceClaimSettlementService.save(zInsuranceClaimSettlement);
		addMessage(redirectAttributes, "保存保险理赔业务查询成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zInsuranceClaimSettlement/?repage";
	}
	
	@RequiresPermissions("zsys:zInsuranceClaimSettlement:edit")
	@RequestMapping(value = "delete")
	public String delete(ZInsuranceClaimSettlement zInsuranceClaimSettlement, RedirectAttributes redirectAttributes) {
		zInsuranceClaimSettlementService.delete(zInsuranceClaimSettlement);
		addMessage(redirectAttributes, "删除保险理赔业务查询成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zInsuranceClaimSettlement/?repage";
	}

}