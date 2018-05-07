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
import com.thinkgem.jeesite.modules.zsys.entity.ZLossArticles;
import com.thinkgem.jeesite.modules.zsys.service.ZLossArticlesService;

/**
 * 遗失物品挂失Controller
 * @author 遗失物品挂失
 * @version 2018-01-25
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/zLossArticles")
public class ZLossArticlesFrontController extends BaseController {

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
	
	@RequestMapping(value = {"list", ""})
	public String list(ZLossArticles zLossArticles, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZLossArticles> page = zLossArticlesService.findPage(new Page<ZLossArticles>(request, response), zLossArticles); 
		model.addAttribute("page", page);
		model.addAttribute("zLossArticles", zLossArticles);
		
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zLossArticlesList";
	}

	@RequestMapping(value = "formDetail")
	public String formDetail(ZLossArticles zLossArticles, HttpServletRequest request, HttpServletResponse response, Model model) {
		zLossArticles = get(zLossArticles.getId());
		model.addAttribute("zLossArticles", zLossArticles);
		return "modules/cms/front/themes/taixhome/actionPage/zsys/zLossArticlesForm";
	}

}