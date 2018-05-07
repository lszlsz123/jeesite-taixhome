/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zsys.entity.ZRespVehicleInfo;

/**
 * 责任经营车辆信息查询DAO接口
 * @author tom
 * @version 2017-12-13
 */
@MyBatisDao
public interface ZRespVehicleInfoDao extends CrudDao<ZRespVehicleInfo> {
	
	/**
	 * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
	 * @param entity
	 * @return
	 */
	public List<ZRespVehicleInfo> findFrontList(ZRespVehicleInfo entity);
}