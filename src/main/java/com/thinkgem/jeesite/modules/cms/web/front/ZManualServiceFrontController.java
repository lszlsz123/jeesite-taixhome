/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web.front;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.zsys.entity.ZManualService;
import com.thinkgem.jeesite.modules.zsys.service.ZManualServiceService;

/**
 * 人工服务Controller
 * @author tom
 * @version 2017-12-26
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zManualService")
public class ZManualServiceFrontController extends BaseController {

	@Autowired
	private ZManualServiceService zManualServiceService;
	
	@ModelAttribute
	public ZManualService get(@RequestParam(required=false) String id) {
		ZManualService entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zManualServiceService.get(id);
		}
		if (entity == null){
			entity = new ZManualService();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ZManualService zManualService, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZManualService> page = zManualServiceService.findPage(new Page<ZManualService>(request, response), zManualService); 
		model.addAttribute("page", page);
		model.addAttribute("zManualService", zManualService);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zManualServiceList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZManualService zManualService, HttpServletRequest request, HttpServletResponse response, Model model) {
		zManualService = get(zManualService.getId());
		model.addAttribute("zManualService", zManualService);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zManualServiceForm";
	}
	
	@RequestMapping(value = "form")
	public String form(ZManualService zManualService, Model model) {
		model.addAttribute("zManualService", zManualService);
		return "modules/zsys/zManualServiceForm";
	}
	
	@RequestMapping(value = "save")
	public String save(ZManualService zManualService, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zManualService)){
			return form(zManualService, model);
		}
		zManualService.setStatus("1");
		zManualServiceService.save(zManualService);
		addMessage(redirectAttributes, "保存人工服务成功");
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zManualServiceForm";
	}

}