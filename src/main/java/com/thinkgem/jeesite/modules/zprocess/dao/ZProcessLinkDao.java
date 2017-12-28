/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessLink;

/**
 * 流程步骤管理DAO接口
 * @author tom
 * @version 2017-12-24
 */
@MyBatisDao
public interface ZProcessLinkDao extends CrudDao<ZProcessLink> {
	
}