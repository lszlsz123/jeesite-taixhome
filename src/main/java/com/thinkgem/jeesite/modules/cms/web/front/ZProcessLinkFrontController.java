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
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessLink;
import com.thinkgem.jeesite.modules.zprocess.service.ZProcessLinkService;

/**
 * 流程步骤管理Controller
 * @author tom
 * @version 2017-12-24
 */
@Controller
@RequestMapping(value = "${frontPath}/zprocess/zProcessLink")
public class ZProcessLinkFrontController extends BaseController {

	@Autowired
	private ZProcessLinkService zProcessLinkService;
	
	@ModelAttribute
	public ZProcessLink get(@RequestParam(required=false) String id) {
		ZProcessLink entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zProcessLinkService.get(id);
		}
		if (entity == null){
			entity = new ZProcessLink();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ZProcessLink zProcessLink, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZProcessLink> page = zProcessLinkService.findPage(new Page<ZProcessLink>(request, response), zProcessLink); 
		model.addAttribute("page", page);
		model.addAttribute("zProcessLink", zProcessLink);
		
		return "modules/cms/front/themes/taixhome/actionPage/zprocess/zProcessLinkList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZProcessLink zProcessLink, HttpServletRequest request, HttpServletResponse response, Model model) {
		zProcessLink = get(zProcessLink.getId());
		model.addAttribute("zProcessLink", zProcessLink);
		return "modules/cms/front/themes/taixhome/actionPage/zprocess/zProcessLinkForm";
	}

}