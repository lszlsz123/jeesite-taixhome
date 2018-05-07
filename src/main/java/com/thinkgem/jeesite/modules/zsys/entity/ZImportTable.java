/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * excel导入数据库表管理Entity
 * @author tom
 * @version 2018-01-08
 */
public class ZImportTable extends DataEntity<ZImportTable> {
	
	private static final long serialVersionUID = 1L;
	private String tableName;		// 表名称
	private String tableId;		// 表ID
	private String sheetName;		// sheet名称
	
	public ZImportTable() {
		super();
	}

	public ZImportTable(String id){
		super(id);
	}

	@Length(min=0, max=50, message="表名称长度必须介于 0 和 50 之间")
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	@Length(min=0, max=64, message="表ID长度必须介于 0 和 64 之间")
	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	
	@Length(min=0, max=50, message="sheet名称长度必须介于 0 和 50 之间")
	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	
}