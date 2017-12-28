/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZManualService;
import com.thinkgem.jeesite.modules.zsys.dao.ZManualServiceDao;

/**
 * 人工服务Service
 * @author tom
 * @version 2017-12-26
 */
@Service
@Transactional(readOnly = true)
public class ZManualServiceService extends CrudService<ZManualServiceDao, ZManualService> {

	public ZManualService get(String id) {
		return super.get(id);
	}
	
	public List<ZManualService> findList(ZManualService zManualService) {
		return super.findList(zManualService);
	}
	
	public Page<ZManualService> findPage(Page<ZManualService> page, ZManualService zManualService) {
		return super.findPage(page, zManualService);
	}
	
	@Transactional(readOnly = false)
	public void save(ZManualService zManualService) {
		super.save(zManualService);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZManualService zManualService) {
		super.delete(zManualService);
	}
	@Transactional(readOnly = false)
	public void update(ZManualService zManualService) {
		dao.update(zManualService);
	}
}