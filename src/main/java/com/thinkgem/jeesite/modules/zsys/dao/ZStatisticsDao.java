/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.dao;

import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zsys.entity.ZStatistics;

/**
 * 责任经营者变更业务办理查询DAO接口
 * @author tom
 * @version 2017-12-14
 */
@MyBatisDao
public interface ZStatisticsDao extends CrudDao<ZStatistics> {
	
	public List<Map<String,Object>> statisticsData(ZStatistics entity);
	
	public String statisticsCount(ZStatistics entity);
	
	public List<Map<String,Object>> statisticsData1(ZStatistics entity);
	
	public List<Map<String,Object>> getDateAndVehicle(ZStatistics entity);
	
	public List<String> getVehicleNum(ZStatistics entity);
}