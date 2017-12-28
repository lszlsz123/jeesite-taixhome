/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZVehicleInsurance;
import com.thinkgem.jeesite.modules.zsys.dao.ZVehicleInsuranceDao;

/**
 * 车辆投保情况查询Service
 * @author tom
 * @version 2017-12-17
 */
@Service
@Transactional(readOnly = true)
public class ZVehicleInsuranceService extends CrudService<ZVehicleInsuranceDao, ZVehicleInsurance> {

	public ZVehicleInsurance get(String id) {
		return super.get(id);
	}
	
	public List<ZVehicleInsurance> findList(ZVehicleInsurance zVehicleInsurance) {
		return super.findList(zVehicleInsurance);
	}
	
	public Page<ZVehicleInsurance> findPage(Page<ZVehicleInsurance> page, ZVehicleInsurance zVehicleInsurance) {
		return super.findPage(page, zVehicleInsurance);
	}
	
	@Transactional(readOnly = false)
	public void save(ZVehicleInsurance zVehicleInsurance) {
		super.save(zVehicleInsurance);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZVehicleInsurance zVehicleInsurance) {
		super.delete(zVehicleInsurance);
	}
	
}