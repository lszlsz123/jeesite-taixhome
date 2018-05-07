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
import com.thinkgem.jeesite.modules.zsys.entity.ZImportTableColumn;
import com.thinkgem.jeesite.modules.zsys.service.ZImportTableColumnService;

/**
 * excel导入数据库列管理Controller
 * @author tom
 * @version 2018-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/zsys/zImportTableColumn")
public class ZImportTableColumnController extends BaseController {

	@Autowired
	private ZImportTableColumnService zImportTableColumnService;
	
//	@Autowired
//	private 
	@ModelAttribute
	public ZImportTableColumn get(@RequestParam(required=false) String id) {
		ZImportTableColumn entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zImportTableColumnService.get(id);
		}
		if (entity == null){
			entity = new ZImportTableColumn();
		}
		return entity;
	}
	
	@RequiresPermissions("zsys:zImportTableColumn:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZImportTableColumn zImportTableColumn, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZImportTableColumn> page = zImportTableColumnService.findPage(new Page<ZImportTableColumn>(request, response), zImportTableColumn); 
		model.addAttribute("page", page);
		model.addAttribute("zImportTableColumn", zImportTableColumn);
		
		return "modules/zsys/zImportTableColumnList";
	}

	@RequiresPermissions("zsys:zImportTableColumn:view")
	@RequestMapping(value = "form")
	public String form(ZImportTableColumn zImportTableColumn, Model model) {
		model.addAttribute("zImportTableColumn", zImportTableColumn);
		return "modules/zsys/zImportTableColumnForm";
	}

	@RequiresPermissions("zsys:zImportTableColumn:edit")
	@RequestMapping(value = "save")
	public String save(ZImportTableColumn zImportTableColumn, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zImportTableColumn)){
			return form(zImportTableColumn, model);
		}
		zImportTableColumnService.save(zImportTableColumn);
		addMessage(redirectAttributes, "保存excel导入数据库列管理成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zImportTableColumn/?repage";
	}
	
	@RequiresPermissions("zsys:zImportTableColumn:edit")
	@RequestMapping(value = "delete")
	public String delete(ZImportTableColumn zImportTableColumn, RedirectAttributes redirectAttributes) {
		zImportTableColumnService.delete(zImportTableColumn);
		addMessage(redirectAttributes, "删除excel导入数据库列管理成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zImportTableColumn/?repage";
	}

}