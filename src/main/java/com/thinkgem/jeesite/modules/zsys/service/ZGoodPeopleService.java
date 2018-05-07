/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZGoodPeople;
import com.thinkgem.jeesite.modules.zsys.dao.ZGoodPeopleDao;

/**
 * 好人好事Service
 * @author 好人好事
 * @version 2018-01-25
 */
@Service
@Transactional(readOnly = true)
public class ZGoodPeopleService extends CrudService<ZGoodPeopleDao, ZGoodPeople> {

	public ZGoodPeople get(String id) {
		return super.get(id);
	}
	
	public List<ZGoodPeople> findList(ZGoodPeople zGoodPeople) {
		return super.findList(zGoodPeople);
	}
	
	public Page<ZGoodPeople> findPage(Page<ZGoodPeople> page, ZGoodPeople zGoodPeople) {
		return super.findPage(page, zGoodPeople);
	}
	
	@Transactional(readOnly = false)
	public void save(ZGoodPeople zGoodPeople) {
		super.save(zGoodPeople);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZGoodPeople zGoodPeople) {
		super.delete(zGoodPeople);
	}
	
}