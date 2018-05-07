/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZImportTable;
import com.thinkgem.jeesite.modules.zsys.dao.ZImportTableDao;

/**
 * excel导入数据库表管理Service
 * @author tom
 * @version 2018-01-08
 */
@Service
@Transactional(readOnly = true)
public class ZImportTableService extends CrudService<ZImportTableDao, ZImportTable> {

	public ZImportTable get(String id) {
		return super.get(id);
	}
	
	public List<ZImportTable> findList(ZImportTable zImportTable) {
		return super.findList(zImportTable);
	}
	
	public Page<ZImportTable> findPage(Page<ZImportTable> page, ZImportTable zImportTable) {
		return super.findPage(page, zImportTable);
	}
	
	@Transactional(readOnly = false)
	public void save(ZImportTable zImportTable) {
		super.save(zImportTable);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZImportTable zImportTable) {
		super.delete(zImportTable);
	}
	
}