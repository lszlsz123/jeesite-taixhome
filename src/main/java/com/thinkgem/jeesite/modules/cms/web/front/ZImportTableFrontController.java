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
import com.thinkgem.jeesite.modules.zsys.entity.ZImportTable;
import com.thinkgem.jeesite.modules.zsys.service.ZImportTableService;

/**
 * excel导入数据库表管理Controller
 * @author tom
 * @version 2018-01-08
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zImportTable")
public class ZImportTableFrontController extends BaseController {

	@Autowired
	private ZImportTableService zImportTableService;
	
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
	
	@RequestMapping(value = {"list", ""})
	public String list(ZImportTable zImportTable, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZImportTable> page = zImportTableService.findPage(new Page<ZImportTable>(request, response), zImportTable); 
		model.addAttribute("page", page);
		model.addAttribute("zImportTable", zImportTable);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zImportTableList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZImportTable zImportTable, HttpServletRequest request, HttpServletResponse response, Model model) {
		zImportTable = get(zImportTable.getId());
		model.addAttribute("zImportTable", zImportTable);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zImportTableForm";
	}

}