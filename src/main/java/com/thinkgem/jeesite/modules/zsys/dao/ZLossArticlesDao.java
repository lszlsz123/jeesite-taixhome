/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zsys.entity.ZLossArticles;

/**
 * 遗失物品挂失DAO接口
 * @author 遗失物品挂失
 * @version 2018-01-25
 */
@MyBatisDao
public interface ZLossArticlesDao extends CrudDao<ZLossArticles> {
	
}