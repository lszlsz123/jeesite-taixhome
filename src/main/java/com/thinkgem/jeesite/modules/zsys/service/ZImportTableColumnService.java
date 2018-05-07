/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zsys.entity.ZImportTableColumn;
import com.thinkgem.jeesite.modules.zsys.dao.ZImportTableColumnDao;

/**
 * excel导入数据库列管理Service
 * @author tom
 * @version 2018-01-08
 */
@Service
@Transactional(readOnly = true)
public class ZImportTableColumnService extends CrudService<ZImportTableColumnDao, ZImportTableColumn> {

	public ZImportTableColumn get(String id) {
		return super.get(id);
	}
	
	public List<ZImportTableColumn> findList(ZImportTableColumn zImportTableColumn) {
		return super.findList(zImportTableColumn);
	}
	
	public Page<ZImportTableColumn> findPage(Page<ZImportTableColumn> page, ZImportTableColumn zImportTableColumn) {
		return super.findPage(page, zImportTableColumn);
	}
	
	@Transactional(readOnly = false)
	public void save(ZImportTableColumn zImportTableColumn) {
		super.save(zImportTableColumn);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZImportTableColumn zImportTableColumn) {
		super.delete(zImportTableColumn);
	}
	
}