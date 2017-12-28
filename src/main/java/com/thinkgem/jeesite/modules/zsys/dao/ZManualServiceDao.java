/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zsys.entity.ZManualService;

/**
 * 人工服务DAO接口
 * @author tom
 * @version 2017-12-26
 */
@MyBatisDao
public interface ZManualServiceDao extends CrudDao<ZManualService> {
	
}