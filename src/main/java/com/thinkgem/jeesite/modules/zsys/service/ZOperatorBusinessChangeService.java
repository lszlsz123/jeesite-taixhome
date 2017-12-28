/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZOperatorBusinessChange;
import com.thinkgem.jeesite.modules.zsys.dao.ZOperatorBusinessChangeDao;

/**
 * 责任经营者变更业务办理查询Service
 * @author tom
 * @version 2017-12-14
 */
@Service
@Transactional(readOnly = true)
public class ZOperatorBusinessChangeService extends CrudService<ZOperatorBusinessChangeDao, ZOperatorBusinessChange> {

	public ZOperatorBusinessChange get(String id) {
		return super.get(id);
	}
	
	public List<ZOperatorBusinessChange> findList(ZOperatorBusinessChange zOperatorBusinessChange) {
		return super.findList(zOperatorBusinessChange);
	}
	
	public Page<ZOperatorBusinessChange> findPage(Page<ZOperatorBusinessChange> page, ZOperatorBusinessChange zOperatorBusinessChange) {
		return super.findPage(page, zOperatorBusinessChange);
	}
	
	@Transactional(readOnly = false)
	public void save(ZOperatorBusinessChange zOperatorBusinessChange) {
		super.save(zOperatorBusinessChange);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZOperatorBusinessChange zOperatorBusinessChange) {
		super.delete(zOperatorBusinessChange);
	}
	
}