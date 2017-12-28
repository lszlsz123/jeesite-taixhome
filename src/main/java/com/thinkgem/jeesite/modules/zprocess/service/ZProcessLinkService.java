/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessLink;
import com.thinkgem.jeesite.modules.zprocess.dao.ZProcessLinkDao;

/**
 * 流程步骤管理Service
 * @author tom
 * @version 2017-12-24
 */
@Service
@Transactional(readOnly = true)
public class ZProcessLinkService extends CrudService<ZProcessLinkDao, ZProcessLink> {

	public ZProcessLink get(String id) {
		return super.get(id);
	}
	
	public List<ZProcessLink> findList(ZProcessLink zProcessLink) {
		return super.findList(zProcessLink);
	}
	
	public Page<ZProcessLink> findPage(Page<ZProcessLink> page, ZProcessLink zProcessLink) {
		return super.findPage(page, zProcessLink);
	}
	
	@Transactional(readOnly = false)
	public void save(ZProcessLink zProcessLink) {
		super.save(zProcessLink);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZProcessLink zProcessLink) {
		super.delete(zProcessLink);
	}
	
}