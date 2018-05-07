/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.util.json.JSONArray;
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
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.zsys.entity.ZManualService;
import com.thinkgem.jeesite.modules.zsys.service.ZManualServiceService;

/**
 * 人工服务Controller
 * @author tom
 * @version 2017-12-26
 */
@Controller
@RequestMapping(value = "${adminPath}/zsys/zManualService")
public class ZManualServiceController extends BaseController {

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
	
	@RequiresPermissions("zsys:zManualService:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZManualService zManualService, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZManualService> page = zManualServiceService.findPage(new Page<ZManualService>(request, response), zManualService); 
		model.addAttribute("page", page);
		model.addAttribute("zManualService", zManualService);
		
		return "modules/zsys/zManualServiceList";
	}

	@RequiresPermissions("zsys:zManualService:view")
	@RequestMapping(value = "form")
	public String form(ZManualService zManualService, Model model) {
		model.addAttribute("zManualService", zManualService);
		return "modules/zsys/zManualServiceForm";
	}

	@RequiresPermissions("zsys:zManualService:edit")
	@RequestMapping(value = "save")
	public String save(ZManualService zManualService, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zManualService)){
			return form(zManualService, model);
		}
		zManualServiceService.save(zManualService);
		addMessage(redirectAttributes, "保存人工服务成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zManualService/?repage";
	}
	
	@RequiresPermissions("zsys:zManualService:edit")
	@RequestMapping(value = "delete")
	public String delete(ZManualService zManualService, RedirectAttributes redirectAttributes) {
		zManualServiceService.delete(zManualService);
		addMessage(redirectAttributes, "删除人工服务成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zManualService/?repage";
	}
	@RequiresPermissions("zsys:zManualService:view")
	@ResponseBody
	@RequestMapping(value = "findManualServiceList", method=RequestMethod.POST)
	public List<ZManualService> findManualServiceList(HttpServletRequest request) throws ParseException {
		JSONObject json = new JSONObject();
		ZManualService queryVO = new ZManualService();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date startDate = sdf1.parse(sdf.format(date)+" 00:00:01");
		Date endDate = sdf1.parse(sdf.format(date)+" 23:59:59");
		queryVO.setDelFlag("0");
		queryVO.setStatus("1");
		queryVO.setBeginCreateDate(startDate);
		queryVO.setEndCreateDate(endDate);
		List<ZManualService> entityList = zManualServiceService.findList(queryVO);
//		JSONArray array = new JSONArray();
//		for(ZManualService item:entityList) {
//			array.put(item.getId());
//		}
//		json.put("ids", array);
//		json.put("length", entityList.size());
		return entityList;
	}
	
	@RequiresPermissions("zsys:zManualService:edit")
	@ResponseBody
	@RequestMapping(value = "updateManualServiceList", method=RequestMethod.POST)
	public String updateManualServiceList(HttpServletRequest request) throws ParseException {
		JSONObject json = new JSONObject();
		ZManualService queryVO = new ZManualService();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date startDate = sdf1.parse(sdf.format(date)+" 00:00:01");
		Date endDate = sdf1.parse(sdf.format(date)+" 23:59:59");
		queryVO.setDelFlag("0");
		queryVO.setBeginCreateDate(startDate);
		queryVO.setEndCreateDate(endDate);
		List<ZManualService> entityList = zManualServiceService.findList(queryVO);
		JSONArray array = new JSONArray();
		for(ZManualService item:entityList) {
			array.put(item.getId());
			item.setStatus("2");
			zManualServiceService.update(item);
		}
		json.put("ids", array);
		json.put("length", entityList.size());
		return json.toString();
	}
	

}