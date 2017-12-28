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
import com.thinkgem.jeesite.modules.zsys.entity.ZRespVehicleInfo;
import com.thinkgem.jeesite.modules.zsys.service.ZRespVehicleInfoService;

/**
 * 责任经营车辆信息查询Controller
 * @author tom
 * @version 2017-12-13
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zRespVehicleInfo")
public class ZRespVehicleInfoFrontController extends BaseController {

	@Autowired
	private ZRespVehicleInfoService zRespVehicleInfoService;
	
	@ModelAttribute
	public ZRespVehicleInfo get(@RequestParam(required=false) String id) {
		ZRespVehicleInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zRespVehicleInfoService.get(id);
		}
		if (entity == null){
			entity = new ZRespVehicleInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ZRespVehicleInfo zRespVehicleInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZRespVehicleInfo> page = zRespVehicleInfoService.findPage(new Page<ZRespVehicleInfo>(request, response), zRespVehicleInfo); 
		model.addAttribute("page", page);
		model.addAttribute("zRespVehicleInfo", zRespVehicleInfo);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zRespVehicleInfoList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZRespVehicleInfo zRespVehicleInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		zRespVehicleInfo = get(zRespVehicleInfo.getId());
		model.addAttribute("zRespVehicleInfo", zRespVehicleInfo);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zRespVehicleInfoForm";
	}

}