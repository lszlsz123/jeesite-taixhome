/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web.front;

import java.util.ArrayList;
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

import com.alibaba.druid.support.json.JSONParser;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessLink;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessNode;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessStep;
import com.thinkgem.jeesite.modules.zprocess.service.ZProcessLinkService;
import com.thinkgem.jeesite.modules.zprocess.service.ZProcessNodeService;
import com.thinkgem.jeesite.modules.zprocess.service.ZProcessStepService;
import com.thinkgem.jeesite.modules.zsys.entity.ZAccident;
import com.thinkgem.jeesite.modules.zsys.service.ZAccidentService;

/**
 * 交通事故查询Controller
 * @author tom
 * @version 2017-12-17
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zAccident")
public class ZAccidentFrontController extends BaseController {

	@Autowired
	private ZAccidentService zAccidentService;
	
	@Autowired
	private ZProcessStepService zProcessStepService;
	
	@Autowired
	private ZProcessNodeService zProcessNodeService;
	
	@ModelAttribute
	public ZAccident get(@RequestParam(required=false) String id) {
		ZAccident entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zAccidentService.get(id);
		}
		if (entity == null){
			entity = new ZAccident();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ZAccident zAccident, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		if(null!=zAccident.getAccTime() || StringUtils.isNotBlank(zAccident.getVehicleInsuranceCompany())||StringUtils.isNotBlank(zAccident.getEstimationAmount())||
			null!=zAccident.getBeginCloseDate()||StringUtils.isNotBlank(zAccident.getAccVehcileNum())||StringUtils.isNotBlank(zAccident.getDriverName())||
			StringUtils.isNotBlank(zAccident.getAccidentNum())||StringUtils.isNotBlank(zAccident.getDriverLicense())||StringUtils.isNotBlank(zAccident.getQueryCode())||
			StringUtils.isNotBlank(zAccident.getRespSituation())
			
				) {
			
			Page<ZAccident> page = zAccidentService.findPage(new Page<ZAccident>(request, response), zAccident); 
			model.addAttribute("page", page);
			model.addAttribute("zAccident", zAccident);
		}
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zAccidentList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZAccident zAccident, HttpServletRequest request, HttpServletResponse response, Model model) {
		zAccident = get(zAccident.getId());
		ZAccident queryVO = new ZAccident();
		queryVO.setAccVehcileNum(zAccident.getAccVehcileNum());
		queryVO.setQueryCode(zAccident.getQueryCode());
		Page<ZAccident> page = zAccidentService.findPage(new Page<ZAccident>(request, response), queryVO); 
		model.addAttribute("zAccident", zAccident);
		model.addAttribute("page", page);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zAccidentForm";
	}
	
	@RequestMapping(value="processDetail")
	public String processDetail(ZAccident zAccident, HttpServletRequest request, HttpServletResponse response, Model model) {
		zAccident = get(zAccident.getId());
		model.addAttribute("zAccident", zAccident);
		zAccident.getProcessId();
		ZProcessStep step = new ZProcessStep();
		step.setAccId(zAccident.getId());
		List<ZProcessStep> stepList = zProcessStepService.findList(step);
		List<ZProcessNode> nodeList = new ArrayList<ZProcessNode>();
		for(int i =0; i<stepList.size();i++) {
			nodeList.add(zProcessNodeService.get(stepList.get(i).getNodeId()));
		}
		StringBuffer jsonSB = new StringBuffer();
		for(int i =0; i<nodeList.size();i++) {
			if(i==0) {
				jsonSB.append(nodeList.get(i).getName());
			}else {
				jsonSB.append("|"+nodeList.get(i).getName());
			}
		}
		model.addAttribute("nodeList",jsonSB.toString());
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zAccidentProcessDetail";
	}

}