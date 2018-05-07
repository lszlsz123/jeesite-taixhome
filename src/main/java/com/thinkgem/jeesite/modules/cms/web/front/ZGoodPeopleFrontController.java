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
import com.thinkgem.jeesite.modules.zsys.entity.ZGoodPeople;
import com.thinkgem.jeesite.modules.zsys.service.ZGoodPeopleService;

/**
 * 好人好事Controller
 * @author 好人好事
 * @version 2018-01-25
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zGoodPeople")
public class ZGoodPeopleFrontController extends BaseController {

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
	
	@RequestMapping(value = {"list", ""})
	public String list(ZGoodPeople zGoodPeople, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZGoodPeople> page = zGoodPeopleService.findPage(new Page<ZGoodPeople>(request, response), zGoodPeople); 
		model.addAttribute("page", page);
		model.addAttribute("zGoodPeople", zGoodPeople);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zGoodPeopleList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZGoodPeople zGoodPeople, HttpServletRequest request, HttpServletResponse response, Model model) {
		zGoodPeople = get(zGoodPeople.getId());
		model.addAttribute("zGoodPeople", zGoodPeople);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zGoodPeopleForm";
	}

}