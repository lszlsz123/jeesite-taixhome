/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessNode;

/**
 * 流程节点管理DAO接口
 * @author tom
 * @version 2018-01-07
 */
@MyBatisDao
public interface ZProcessNodeDao extends CrudDao<ZProcessNode> {
	public List<ZProcessNode> findListByIds(String[] ids);
}