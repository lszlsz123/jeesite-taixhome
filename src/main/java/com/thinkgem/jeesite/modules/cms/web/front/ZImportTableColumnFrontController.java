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
import com.thinkgem.jeesite.modules.zsys.entity.ZImportTableColumn;
import com.thinkgem.jeesite.modules.zsys.service.ZImportTableColumnService;

/**
 * excel导入数据库列管理Controller
 * @author tom
 * @version 2018-01-08
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zImportTableColumn")
public class ZImportTableColumnFrontController extends BaseController {

	@Autowired
	private ZImportTableColumnService zImportTableColumnService;
	
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
	
	@RequestMapping(value = {"list", ""})
	public String list(ZImportTableColumn zImportTableColumn, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZImportTableColumn> page = zImportTableColumnService.findPage(new Page<ZImportTableColumn>(request, response), zImportTableColumn); 
		model.addAttribute("page", page);
		model.addAttribute("zImportTableColumn", zImportTableColumn);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zImportTableColumnList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZImportTableColumn zImportTableColumn, HttpServletRequest request, HttpServletResponse response, Model model) {
		zImportTableColumn = get(zImportTableColumn.getId());
		model.addAttribute("zImportTableColumn", zImportTableColumn);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zImportTableColumnForm";
	}

}