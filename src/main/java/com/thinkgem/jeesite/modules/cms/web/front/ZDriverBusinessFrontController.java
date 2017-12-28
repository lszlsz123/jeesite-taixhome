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
import com.thinkgem.jeesite.modules.zsys.entity.ZDriverBusiness;
import com.thinkgem.jeesite.modules.zsys.service.ZDriverBusinessService;

/**
 * 从业司机业务办理查询Controller
 * @author tom
 * @version 2017-12-14
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zDriverBusiness")
public class ZDriverBusinessFrontController extends BaseController {

	@Autowired
	private ZDriverBusinessService zDriverBusinessService;
	
	@ModelAttribute
	public ZDriverBusiness get(@RequestParam(required=false) String id) {
		ZDriverBusiness entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zDriverBusinessService.get(id);
		}
		if (entity == null){
			entity = new ZDriverBusiness();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ZDriverBusiness zDriverBusiness, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZDriverBusiness> page = zDriverBusinessService.findPage(new Page<ZDriverBusiness>(request, response), zDriverBusiness); 
		model.addAttribute("page", page);
		model.addAttribute("zDriverBusiness", zDriverBusiness);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zDriverBusinessList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZDriverBusiness zDriverBusiness, HttpServletRequest request, HttpServletResponse response, Model model) {
		zDriverBusiness = get(zDriverBusiness.getId());
		model.addAttribute("zDriverBusiness", zDriverBusiness);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zDriverBusinessForm";
	}

}