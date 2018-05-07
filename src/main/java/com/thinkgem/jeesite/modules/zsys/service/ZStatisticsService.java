/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.dao.ZStatisticsDao;
import com.thinkgem.jeesite.modules.zsys.entity.ZStatistics;

/**
 * 责任经营者变更业务办理查询Service
 * @author tom
 * @version 2017-12-14
 */
@Service
@Transactional(readOnly = true)
public class ZStatisticsService extends CrudService<ZStatisticsDao, ZStatistics> {

	
	public Map<String, Object> statisticsData(String searchTableName){
		Map<String, Object> map = new HashMap<String, Object>();
		ZStatistics entity = new ZStatistics();
		entity.setSearchTableName(searchTableName);
		List<Map<String,Object>> list = dao.statisticsData(entity);
		for(Map<String,Object> item: list) {
			map.put((String) item.get("key"), Integer.parseInt(item.get("value").toString()));
		}
		return map;
	}
	
	public Map<String, Object> statisticsCount(String SQL){
		Map<String, Object> map = new HashMap<String, Object>();
		ZStatistics entity = new ZStatistics();
		entity.setSQL(SQL);
		String count = dao.statisticsCount(entity);
		map.put("count", count);
		return map;
	}
	
	public List<Map<String, Object>> getDateAndVehicle(String SQL){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		ZStatistics entity = new ZStatistics();
		entity.setSQL(SQL);
		//[{key="2018-01-01",value="中华车2018"}，{key="2018-01-02",value="中华车2017"}]
		list = dao.getDateAndVehicle(entity);
		
		return list;
	}
	
	public List<String> getVehicleNum(String SQL){
		ZStatistics entity = new ZStatistics();
		entity.setSQL(SQL);
		List<String> list = new ArrayList<String>();
		list = dao.getVehicleNum(entity);
		return list;
	}
	
	public Map<String, Object> statisticsData1(String searchTableName,String whereCondition){
		Map<String, Object> map = new HashMap<String, Object>();
		ZStatistics entity = new ZStatistics();
		entity.setSearchTableName(searchTableName);
		entity.setWhereCondition(whereCondition);
		List<Map<String,Object>> list = dao.statisticsData1(entity);
		for(Map<String,Object> item: list) {
			map.put((String) item.get("key"), Integer.parseInt(item.get("value").toString()));
		}
		return map;
	}
}