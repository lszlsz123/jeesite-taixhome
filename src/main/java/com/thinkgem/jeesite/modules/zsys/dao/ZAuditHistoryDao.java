/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zsys.entity.ZAuditHistory;

/**
 * 前台日志DAO接口
 * @author tom
 * @version 2018-01-02
 */
@MyBatisDao
public interface ZAuditHistoryDao extends CrudDao<ZAuditHistory> {
	
}