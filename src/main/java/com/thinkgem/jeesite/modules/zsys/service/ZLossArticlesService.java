/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZLossArticles;
import com.thinkgem.jeesite.modules.zsys.dao.ZLossArticlesDao;

/**
 * 遗失物品挂失Service
 * @author 遗失物品挂失
 * @version 2018-01-25
 */
@Service
@Transactional(readOnly = true)
public class ZLossArticlesService extends CrudService<ZLossArticlesDao, ZLossArticles> {

	public ZLossArticles get(String id) {
		return super.get(id);
	}
	
	public List<ZLossArticles> findList(ZLossArticles zLossArticles) {
		return super.findList(zLossArticles);
	}
	
	public Page<ZLossArticles> findPage(Page<ZLossArticles> page, ZLossArticles zLossArticles) {
		return super.findPage(page, zLossArticles);
	}
	
	@Transactional(readOnly = false)
	public void save(ZLossArticles zLossArticles) {
		super.save(zLossArticles);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZLossArticles zLossArticles) {
		super.delete(zLossArticles);
	}
	
}