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
import com.thinkgem.jeesite.modules.zsys.entity.ZMaintenanceRecord;
import com.thinkgem.jeesite.modules.zsys.service.ZMaintenanceRecordService;

/**
 * 车辆技术维护记录查询Controller
 * @author tom
 * @version 2017-12-18
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zMaintenanceRecord")
public class ZMaintenanceRecordFrontController extends BaseController {

	@Autowired
	private ZMaintenanceRecordService zMaintenanceRecordService;
	
	@ModelAttribute
	public ZMaintenanceRecord get(@RequestParam(required=false) String id) {
		ZMaintenanceRecord entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zMaintenanceRecordService.get(id);
		}
		if (entity == null){
			entity = new ZMaintenanceRecord();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ZMaintenanceRecord zMaintenanceRecord, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZMaintenanceRecord> page = zMaintenanceRecordService.findPage(new Page<ZMaintenanceRecord>(request, response), zMaintenanceRecord); 
		model.addAttribute("page", page);
		model.addAttribute("zMaintenanceRecord", zMaintenanceRecord);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zMaintenanceRecordList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZMaintenanceRecord zMaintenanceRecord, HttpServletRequest request, HttpServletResponse response, Model model) {
		zMaintenanceRecord = get(zMaintenanceRecord.getId());
		model.addAttribute("zMaintenanceRecord", zMaintenanceRecord);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zMaintenanceRecordForm";
	}

}