/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZAccident;
import com.thinkgem.jeesite.modules.zsys.dao.ZAccidentDao;

/**
 * 交通事故查询Service
 * @author tom
 * @version 2017-12-17
 */
@Service
@Transactional(readOnly = true)
public class ZAccidentService extends CrudService<ZAccidentDao, ZAccident> {

	public ZAccident get(String id) {
		return super.get(id);
	}
	
	public List<ZAccident> findList(ZAccident zAccident) {
		return super.findList(zAccident);
	}
	
	public Page<ZAccident> findPage(Page<ZAccident> page, ZAccident zAccident) {
		return super.findPage(page, zAccident);
	}
	
	@Transactional(readOnly = false)
	public void save(ZAccident zAccident) {
		super.save(zAccident);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZAccident zAccident) {
		super.delete(zAccident);
	}
	
}