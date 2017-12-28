/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZInsuranceClaimSettlement;
import com.thinkgem.jeesite.modules.zsys.dao.ZInsuranceClaimSettlementDao;

/**
 * 保险理赔业务查询Service
 * @author tom
 * @version 2017-12-17
 */
@Service
@Transactional(readOnly = true)
public class ZInsuranceClaimSettlementService extends CrudService<ZInsuranceClaimSettlementDao, ZInsuranceClaimSettlement> {

	public ZInsuranceClaimSettlement get(String id) {
		return super.get(id);
	}
	
	public List<ZInsuranceClaimSettlement> findList(ZInsuranceClaimSettlement zInsuranceClaimSettlement) {
		return super.findList(zInsuranceClaimSettlement);
	}
	
	public Page<ZInsuranceClaimSettlement> findPage(Page<ZInsuranceClaimSettlement> page, ZInsuranceClaimSettlement zInsuranceClaimSettlement) {
		return super.findPage(page, zInsuranceClaimSettlement);
	}
	
	@Transactional(readOnly = false)
	public void save(ZInsuranceClaimSettlement zInsuranceClaimSettlement) {
		super.save(zInsuranceClaimSettlement);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZInsuranceClaimSettlement zInsuranceClaimSettlement) {
		super.delete(zInsuranceClaimSettlement);
	}
	
}