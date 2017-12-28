/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessStep;

/**
 * 流程操作节点记录DAO接口
 * @author tom
 * @version 2017-12-24
 */
@MyBatisDao
public interface ZProcessStepDao extends CrudDao<ZProcessStep> {
	
}