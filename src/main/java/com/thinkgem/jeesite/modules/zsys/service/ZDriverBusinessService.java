/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZDriverBusiness;
import com.thinkgem.jeesite.modules.zsys.dao.ZDriverBusinessDao;

/**
 * 从业司机业务办理查询Service
 * @author tom
 * @version 2017-12-14
 */
@Service
@Transactional(readOnly = true)
public class ZDriverBusinessService extends CrudService<ZDriverBusinessDao, ZDriverBusiness> {

	public ZDriverBusiness get(String id) {
		return super.get(id);
	}
	
	public List<ZDriverBusiness> findList(ZDriverBusiness zDriverBusiness) {
		return super.findList(zDriverBusiness);
	}
	
	public Page<ZDriverBusiness> findPage(Page<ZDriverBusiness> page, ZDriverBusiness zDriverBusiness) {
		return super.findPage(page, zDriverBusiness);
	}
	
	@Transactional(readOnly = false)
	public void save(ZDriverBusiness zDriverBusiness) {
		super.save(zDriverBusiness);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZDriverBusiness zDriverBusiness) {
		super.delete(zDriverBusiness);
	}
	
}