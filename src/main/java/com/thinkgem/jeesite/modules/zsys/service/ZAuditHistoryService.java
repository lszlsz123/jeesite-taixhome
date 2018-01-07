/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZAuditHistory;
import com.thinkgem.jeesite.modules.zsys.dao.ZAuditHistoryDao;

/**
 * 前台日志Service
 * @author tom
 * @version 2018-01-02
 */
@Service
@Transactional(readOnly = true)
public class ZAuditHistoryService extends CrudService<ZAuditHistoryDao, ZAuditHistory> {

	public ZAuditHistory get(String id) {
		return super.get(id);
	}
	
	public List<ZAuditHistory> findList(ZAuditHistory zAuditHistory) {
		return super.findList(zAuditHistory);
	}
	
	public Page<ZAuditHistory> findPage(Page<ZAuditHistory> page, ZAuditHistory zAuditHistory) {
		return super.findPage(page, zAuditHistory);
	}
	
	@Transactional(readOnly = false)
	public void save(ZAuditHistory zAuditHistory) {
		super.save(zAuditHistory);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZAuditHistory zAuditHistory) {
		super.delete(zAuditHistory);
	}
	
}