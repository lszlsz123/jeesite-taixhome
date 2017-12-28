/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZOperationViolation;
import com.thinkgem.jeesite.modules.zsys.dao.ZOperationViolationDao;

/**
 * 运营违规记录查询Service
 * @author tom
 * @version 2017-12-28
 */
@Service
@Transactional(readOnly = true)
public class ZOperationViolationService extends CrudService<ZOperationViolationDao, ZOperationViolation> {

	public ZOperationViolation get(String id) {
		return super.get(id);
	}
	
	public List<ZOperationViolation> findList(ZOperationViolation zOperationViolation) {
		return super.findList(zOperationViolation);
	}
	
	public Page<ZOperationViolation> findPage(Page<ZOperationViolation> page, ZOperationViolation zOperationViolation) {
		return super.findPage(page, zOperationViolation);
	}
	
	@Transactional(readOnly = false)
	public void save(ZOperationViolation zOperationViolation) {
		super.save(zOperationViolation);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZOperationViolation zOperationViolation) {
		super.delete(zOperationViolation);
	}
	
}