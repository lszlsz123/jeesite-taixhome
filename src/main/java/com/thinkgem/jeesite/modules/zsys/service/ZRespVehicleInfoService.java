/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZRespVehicleInfo;
import com.thinkgem.jeesite.modules.zsys.dao.ZRespVehicleInfoDao;

/**
 * 责任经营车辆信息查询Service
 * @author tom
 * @version 2017-12-13
 */
@Service
@Transactional(readOnly = true)
public class ZRespVehicleInfoService extends CrudService<ZRespVehicleInfoDao, ZRespVehicleInfo> {

	public ZRespVehicleInfo get(String id) {
		return super.get(id);
	}
	
	public List<ZRespVehicleInfo> findList(ZRespVehicleInfo zRespVehicleInfo) {
		return super.findList(zRespVehicleInfo);
	}
	
	public Page<ZRespVehicleInfo> findPage(Page<ZRespVehicleInfo> page, ZRespVehicleInfo zRespVehicleInfo) {
		return super.findPage(page, zRespVehicleInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(ZRespVehicleInfo zRespVehicleInfo) {
		super.save(zRespVehicleInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZRespVehicleInfo zRespVehicleInfo) {
		super.delete(zRespVehicleInfo);
	}
	
}