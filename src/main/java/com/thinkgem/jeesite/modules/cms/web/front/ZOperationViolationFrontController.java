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
import com.thinkgem.jeesite.modules.zsys.entity.ZOperationViolation;
import com.thinkgem.jeesite.modules.zsys.service.ZOperationViolationService;

/**
 * 运营违规记录查询Controller
 * @author tom
 * @version 2017-12-28
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zOperationViolation")
public class ZOperationViolationFrontController extends BaseController {

	@Autowired
	private ZOperationViolationService zOperationViolationService;
	
	@ModelAttribute
	public ZOperationViolation get(@RequestParam(required=false) String id) {
		ZOperationViolation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zOperationViolationService.get(id);
		}
		if (entity == null){
			entity = new ZOperationViolation();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ZOperationViolation zOperationViolation, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZOperationViolation> page = zOperationViolationService.findPage(new Page<ZOperationViolation>(request, response), zOperationViolation); 
		model.addAttribute("page", page);
		model.addAttribute("zOperationViolation", zOperationViolation);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zOperationViolationList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZOperationViolation zOperationViolation, HttpServletRequest request, HttpServletResponse response, Model model) {
		zOperationViolation = get(zOperationViolation.getId());
		model.addAttribute("zOperationViolation", zOperationViolation);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zOperationViolationForm";
	}

}