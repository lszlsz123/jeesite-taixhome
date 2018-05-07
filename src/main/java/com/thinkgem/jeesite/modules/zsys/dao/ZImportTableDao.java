/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zsys.entity.ZImportTable;

/**
 * excel导入数据库表管理DAO接口
 * @author tom
 * @version 2018-01-08
 */
@MyBatisDao
public interface ZImportTableDao extends CrudDao<ZImportTable> {
	
}