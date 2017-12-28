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
import com.thinkgem.jeesite.modules.zsys.entity.ZOperatorBusinessChange;
import com.thinkgem.jeesite.modules.zsys.service.ZOperatorBusinessChangeService;

/**
 * 责任经营者变更业务办理查询Controller
 * @author tom
 * @version 2017-12-14
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zOperatorBusinessChange")
public class ZOperatorBusinessChangeFrontController extends BaseController {

	@Autowired
	private ZOperatorBusinessChangeService zOperatorBusinessChangeService;
	
	@ModelAttribute
	public ZOperatorBusinessChange get(@RequestParam(required=false) String id) {
		ZOperatorBusinessChange entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zOperatorBusinessChangeService.get(id);
		}
		if (entity == null){
			entity = new ZOperatorBusinessChange();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ZOperatorBusinessChange zOperatorBusinessChange, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZOperatorBusinessChange> page = zOperatorBusinessChangeService.findPage(new Page<ZOperatorBusinessChange>(request, response), zOperatorBusinessChange); 
		model.addAttribute("page", page);
		model.addAttribute("zOperatorBusinessChange", zOperatorBusinessChange);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zOperatorBusinessChangeList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZOperatorBusinessChange zOperatorBusinessChange, HttpServletRequest request, HttpServletResponse response, Model model) {
		zOperatorBusinessChange = get(zOperatorBusinessChange.getId());
		model.addAttribute("zOperatorBusinessChange", zOperatorBusinessChange);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zOperatorBusinessChangeForm";
	}

}