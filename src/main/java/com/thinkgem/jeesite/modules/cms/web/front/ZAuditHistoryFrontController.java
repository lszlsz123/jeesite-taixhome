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
import com.thinkgem.jeesite.modules.zsys.entity.ZAuditHistory;
import com.thinkgem.jeesite.modules.zsys.service.ZAuditHistoryService;

/**
 * 前台日志Controller
 * @author tom
 * @version 2018-01-02
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zAuditHistory")
public class ZAuditHistoryFrontController extends BaseController {

	@Autowired
	private ZAuditHistoryService zAuditHistoryService;
	
	@ModelAttribute
	public ZAuditHistory get(@RequestParam(required=false) String id) {
		ZAuditHistory entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zAuditHistoryService.get(id);
		}
		if (entity == null){
			entity = new ZAuditHistory();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ZAuditHistory zAuditHistory, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZAuditHistory> page = zAuditHistoryService.findPage(new Page<ZAuditHistory>(request, response), zAuditHistory); 
		model.addAttribute("page", page);
		model.addAttribute("zAuditHistory", zAuditHistory);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zAuditHistoryList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZAuditHistory zAuditHistory, HttpServletRequest request, HttpServletResponse response, Model model) {
		zAuditHistory = get(zAuditHistory.getId());
		model.addAttribute("zAuditHistory", zAuditHistory);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zAuditHistoryForm";
	}

}