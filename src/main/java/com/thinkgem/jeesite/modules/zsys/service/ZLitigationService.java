/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZLitigation;
import com.thinkgem.jeesite.modules.zsys.dao.ZLitigationDao;

/**
 * 诉讼案件查询Service
 * @author tom
 * @version 2017-12-17
 */
@Service
@Transactional(readOnly = true)
public class ZLitigationService extends CrudService<ZLitigationDao, ZLitigation> {

	public ZLitigation get(String id) {
		return super.get(id);
	}
	
	public List<ZLitigation> findList(ZLitigation zLitigation) {
		return super.findList(zLitigation);
	}
	
	public Page<ZLitigation> findPage(Page<ZLitigation> page, ZLitigation zLitigation) {
		return super.findPage(page, zLitigation);
	}
	
	@Transactional(readOnly = false)
	public void save(ZLitigation zLitigation) {
		super.save(zLitigation);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZLitigation zLitigation) {
		super.delete(zLitigation);
	}
	
}