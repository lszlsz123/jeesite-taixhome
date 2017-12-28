/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zsys.entity.ZMaintenanceRecord;

/**
 * 车辆技术维护记录查询DAO接口
 * @author tom
 * @version 2017-12-18
 */
@MyBatisDao
public interface ZMaintenanceRecordDao extends CrudDao<ZMaintenanceRecord> {
	
}