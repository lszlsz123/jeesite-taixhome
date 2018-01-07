/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZMakeUpLoss;
import com.thinkgem.jeesite.modules.zsys.dao.ZMakeUpLossDao;

/**
 * 证件遗失补办业务Service
 * @author tom
 * @version 2018-01-02
 */
@Service
@Transactional(readOnly = true)
public class ZMakeUpLossService extends CrudService<ZMakeUpLossDao, ZMakeUpLoss> {

	public ZMakeUpLoss get(String id) {
		return super.get(id);
	}
	
	public List<ZMakeUpLoss> findList(ZMakeUpLoss zMakeUpLoss) {
		return super.findList(zMakeUpLoss);
	}
	
	public Page<ZMakeUpLoss> findPage(Page<ZMakeUpLoss> page, ZMakeUpLoss zMakeUpLoss) {
		return super.findPage(page, zMakeUpLoss);
	}
	
	@Transactional(readOnly = false)
	public void save(ZMakeUpLoss zMakeUpLoss) {
		super.save(zMakeUpLoss);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZMakeUpLoss zMakeUpLoss) {
		super.delete(zMakeUpLoss);
	}
	
}