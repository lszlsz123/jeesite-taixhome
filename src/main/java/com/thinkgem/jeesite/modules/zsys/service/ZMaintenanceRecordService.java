/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZMaintenanceRecord;
import com.thinkgem.jeesite.modules.zsys.dao.ZMaintenanceRecordDao;

/**
 * 车辆技术维护记录查询Service
 * @author tom
 * @version 2017-12-18
 */
@Service
@Transactional(readOnly = true)
public class ZMaintenanceRecordService extends CrudService<ZMaintenanceRecordDao, ZMaintenanceRecord> {

	public ZMaintenanceRecord get(String id) {
		return super.get(id);
	}
	
	public List<ZMaintenanceRecord> findList(ZMaintenanceRecord zMaintenanceRecord) {
		return super.findList(zMaintenanceRecord);
	}
	
	public Page<ZMaintenanceRecord> findPage(Page<ZMaintenanceRecord> page, ZMaintenanceRecord zMaintenanceRecord) {
		return super.findPage(page, zMaintenanceRecord);
	}
	
	@Transactional(readOnly = false)
	public void save(ZMaintenanceRecord zMaintenanceRecord) {
		super.save(zMaintenanceRecord);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZMaintenanceRecord zMaintenanceRecord) {
		super.delete(zMaintenanceRecord);
	}
	
}