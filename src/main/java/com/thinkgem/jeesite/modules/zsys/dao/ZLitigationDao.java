/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zsys.entity.ZLitigation;

/**
 * 诉讼案件查询DAO接口
 * @author tom
 * @version 2017-12-17
 */
@MyBatisDao
public interface ZLitigationDao extends CrudDao<ZLitigation> {
	
}