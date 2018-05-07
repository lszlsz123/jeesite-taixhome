/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.web;

import java.util.List;

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
import com.thinkgem.jeesite.modules.gen.entity.GenTable;
import com.thinkgem.jeesite.modules.gen.service.GenTableService;
import com.thinkgem.jeesite.modules.zsys.entity.ZImportTable;
import com.thinkgem.jeesite.modules.zsys.service.ZImportTableService;

/**
 * excel导入数据库表管理Controller
 * @author tom
 * @version 2018-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/zsys/zImportTable")
public class ZImportTableController extends BaseController {

	@Autowired
	private ZImportTableService zImportTableService;
	
	@Autowired
	private GenTableService genTableService;
	
	@ModelAttribute
	public ZImportTable get(@RequestParam(required=false) String id) {
		ZImportTable entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zImportTableService.get(id);
		}
		if (entity == null){
			entity = new ZImportTable();
		}
		return entity;
	}
	
	@RequiresPermissions("zsys:zImportTable:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZImportTable zImportTable, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZImportTable> page = zImportTableService.findPage(new Page<ZImportTable>(request, response), zImportTable); 
		model.addAttribute("page", page);
		model.addAttribute("zImportTable", zImportTable);
		
		return "modules/zsys/zImportTableList";
	}

	@RequiresPermissions("zsys:zImportTable:view")
	@RequestMapping(value = "form")
	public String form(ZImportTable zImportTable, Model model) {
		List<GenTable> tableList = genTableService.findAll();
		model.addAttribute("tableList", tableList);
		model.addAttribute("zImportTable", zImportTable);
		return "modules/zsys/zImportTableForm";
	}

	@RequiresPermissions("zsys:zImportTable:edit")
	@RequestMapping(value = "save")
	public String save(ZImportTable zImportTable, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zImportTable)){
			return form(zImportTable, model);
		}
		zImportTableService.save(zImportTable);
		addMessage(redirectAttributes, "保存excel导入数据库表管理成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zImportTable/?repage";
	}
	
	@RequiresPermissions("zsys:zImportTable:edit")
	@RequestMapping(value = "delete")
	public String delete(ZImportTable zImportTable, RedirectAttributes redirectAttributes) {
		zImportTableService.delete(zImportTable);
		addMessage(redirectAttributes, "删除excel导入数据库表管理成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zImportTable/?repage";
	}

}