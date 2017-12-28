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
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessNode;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessStep;
import com.thinkgem.jeesite.modules.zprocess.service.ZProcessLinkService;
import com.thinkgem.jeesite.modules.zprocess.service.ZProcessNodeService;
import com.thinkgem.jeesite.modules.zprocess.service.ZProcessService;
import com.thinkgem.jeesite.modules.zprocess.service.ZProcessStepService;
import com.thinkgem.jeesite.modules.zsys.entity.ZAccident;
import com.thinkgem.jeesite.modules.zsys.service.ZAccidentService;

/**
 * 交通事故查询Controller
 * @author tom
 * @version 2017-12-17
 */
@Controller
@RequestMapping(value = "${adminPath}/zsys/zAccident")
public class ZAccidentController extends BaseController {

	@Autowired
	private ZAccidentService zAccidentService;
	
	@Autowired
	private ZProcessLinkService zProcessLinkService;
	
	@Autowired
	private ZProcessService zProcessService;
	
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
	
	@RequiresPermissions("zsys:zAccident:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZAccident zAccident, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZAccident> page = zAccidentService.findPage(new Page<ZAccident>(request, response), zAccident); 
		model.addAttribute("page", page);
		model.addAttribute("zAccident", zAccident);
		
		return "modules/zsys/zAccidentList";
	}

	@RequiresPermissions("zsys:zAccident:view")
	@RequestMapping(value = "form")
	public String form(ZAccident zAccident, Model model) {
		ZProcessStep step = new ZProcessStep();
		step.setAccId(zAccident.getId());
		step.setDelFlag("0");
		List<ZProcessStep> stepList = zProcessStepService.findList(step);
		if(stepList != null &&!stepList.isEmpty()) {
			ZProcessStep step2 = stepList.get(0);
			String nodeId = step2.getNodeId();
			ZProcessNode node = zProcessNodeService.get(nodeId);
			if(node!=null) {
				zAccident.setNodeName(node.getName());
			}
			zAccident.setNodeId(nodeId);
		}else {
			zAccident.setNodeId("9f98c072e3514e1fb36be796b35908b5");
		}
		zAccident.setProcessId("56cf538e415d4f00bb2275d3f5a666ca");
		model.addAttribute("zAccident", zAccident);
		
		return "modules/zsys/zAccidentForm";
	}

	@RequiresPermissions("zsys:zAccident:edit")
	@RequestMapping(value = "save")
	public String save(ZAccident zAccident, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zAccident)){
			return form(zAccident, model);
		}
		zAccidentService.save(zAccident);
		if(StringUtils.isNotBlank(zAccident.getStep())) {
			ZProcessStep step = new ZProcessStep();
			step.setAccId(zAccident.getId());
			step.setNodeId(zAccident.getStep());
			zProcessStepService.save(step);
		}
		addMessage(redirectAttributes, "保存交通事故查询成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zAccident/?repage";
	}
	
	@RequiresPermissions("zsys:zAccident:edit")
	@RequestMapping(value = "delete")
	public String delete(ZAccident zAccident, RedirectAttributes redirectAttributes) {
		zAccidentService.delete(zAccident);
		addMessage(redirectAttributes, "删除交通事故查询成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zAccident/?repage";
	}

}