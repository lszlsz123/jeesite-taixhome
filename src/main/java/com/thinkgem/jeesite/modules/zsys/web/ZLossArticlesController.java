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
import com.thinkgem.jeesite.modules.zsys.entity.ZLossArticles;
import com.thinkgem.jeesite.modules.zsys.service.ZLossArticlesService;

/**
 * 遗失物品挂失Controller
 * @author 遗失物品挂失
 * @version 2018-01-25
 */
@Controller
@RequestMapping(value = "${adminPath}/zsys/zLossArticles")
public class ZLossArticlesController extends BaseController {

	@Autowired
	private ZLossArticlesService zLossArticlesService;
	
	@ModelAttribute
	public ZLossArticles get(@RequestParam(required=false) String id) {
		ZLossArticles entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zLossArticlesService.get(id);
		}
		if (entity == null){
			entity = new ZLossArticles();
		}
		return entity;
	}
	
	@RequiresPermissions("zsys:zLossArticles:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZLossArticles zLossArticles, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZLossArticles> page = zLossArticlesService.findPage(new Page<ZLossArticles>(request, response), zLossArticles); 
		model.addAttribute("page", page);
		model.addAttribute("zLossArticles", zLossArticles);
		
		return "modules/zsys/zLossArticlesList";
	}

	@RequiresPermissions("zsys:zLossArticles:view")
	@RequestMapping(value = "form")
	public String form(ZLossArticles zLossArticles, Model model) {
		model.addAttribute("zLossArticles", zLossArticles);
		return "modules/zsys/zLossArticlesForm";
	}

	@RequiresPermissions("zsys:zLossArticles:edit")
	@RequestMapping(value = "save")
	public String save(ZLossArticles zLossArticles, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zLossArticles)){
			return form(zLossArticles, model);
		}
		zLossArticlesService.save(zLossArticles);
		addMessage(redirectAttributes, "保存遗失物品挂失成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zLossArticles/?repage";
	}
	
	@RequiresPermissions("zsys:zLossArticles:edit")
	@RequestMapping(value = "delete")
	public String delete(ZLossArticles zLossArticles, RedirectAttributes redirectAttributes) {
		zLossArticlesService.delete(zLossArticles);
		addMessage(redirectAttributes, "删除遗失物品挂失成功");
		return "redirect:"+Global.getAdminPath()+"/zsys/zLossArticles/?repage";
	}

}