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
import com.thinkgem.jeesite.modules.zsys.entity.ZAuditHistory;
import com.thinkgem.jeesite.modules.zsys.service.ZAuditHistoryService;

/**
 * 前台日志Controller
 * @author tom
 * @version 2018-01-02
 */
@Controller
@RequestMapping(value = "${adminPath}/zsys/zAuditHistory")
public class ZAuditHistoryController extends BaseController {

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
	
	@RequiresPermissions("zsys:zAuditHistory:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZAuditHistory zAuditHistory, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZAuditHistory> page = zAuditHistoryService.findPage(new Page<ZAuditHistory>(request, response), zAuditHistory); 
		model.addAttribute("page", page);
		model.addAttribute("zAuditHistory", zAuditHistory);
		
		return "modules/zsys/zAuditHistoryList";
	}

	@RequiresPermissions("zsys:zAuditHistory:view")
	@RequestMapping(value = "form")
	public String form(ZAuditHistory zAuditHistory, Model model) {
		model.addAttribute("zAuditHistory", zAuditHistory);
		return "modules/zsys/zAuditHistoryForm";
	}

	@RequiresPermissions("zsys:zAuditHistory:edit")
	@RequestMapping(value = "save")
	public String save(ZAuditHistory zAuditHistory, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zAuditHistory)){
			return form(zAuditHistory, model);
		}
		zAuditHistoryService.save(zAuditHistory);
		addMessage(redirectAttributes, "保存前台日志成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zAuditHistory/?repage";
	}
	
	@RequiresPermissions("zsys:zAuditHistory:edit")
	@RequestMapping(value = "delete")
	public String delete(ZAuditHistory zAuditHistory, RedirectAttributes redirectAttributes) {
		zAuditHistoryService.delete(zAuditHistory);
		addMessage(redirectAttributes, "删除前台日志成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zAuditHistory/?repage";
	}

}