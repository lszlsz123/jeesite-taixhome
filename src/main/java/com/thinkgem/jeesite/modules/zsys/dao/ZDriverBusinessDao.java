/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zsys.entity.ZDriverBusiness;

/**
 * 从业司机业务办理查询DAO接口
 * @author tom
 * @version 2017-12-14
 */
@MyBatisDao
public interface ZDriverBusinessDao extends CrudDao<ZDriverBusiness> {
	
}