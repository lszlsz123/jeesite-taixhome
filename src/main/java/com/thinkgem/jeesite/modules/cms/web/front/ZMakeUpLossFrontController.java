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
import com.thinkgem.jeesite.modules.zsys.entity.ZMakeUpLoss;
import com.thinkgem.jeesite.modules.zsys.entity.ZManualService;
import com.thinkgem.jeesite.modules.zsys.service.ZMakeUpLossService;
import com.thinkgem.jeesite.modules.zsys.service.ZManualServiceService;

/**
 * 证件遗失补办业务Controller
 * @author tom
 * @version 2018-01-02
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zMakeUpLoss")
public class ZMakeUpLossFrontController extends BaseController {

	@Autowired
	private ZMakeUpLossService zMakeUpLossService;
	
	@Autowired
	private ZManualServiceService zManualServiceService;
	
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
	
	public String form(ZMakeUpLoss zMakeUpLoss, Model model) {
		model.addAttribute("zMakeUpLoss", zMakeUpLoss);
		return "modules/zsys/zMakeUpLossForm";
	}
	
	@RequestMapping(value = {"call", ""})
	public String call(ZMakeUpLoss zMakeUpLoss, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		if (!beanValidator(model, zMakeUpLoss)){
			return form(zMakeUpLoss, model);
		}
		zMakeUpLossService.save(zMakeUpLoss);
		ZManualService zManualService = new ZManualService();
		
		zManualService.setStatus("1");
		zManualServiceService.save(zManualService);
		
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zManualServiceForm";
	}
	
}