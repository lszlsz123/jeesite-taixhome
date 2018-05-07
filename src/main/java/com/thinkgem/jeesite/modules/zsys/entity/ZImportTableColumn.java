/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * excel导入数据库列管理Entity
 * @author tom
 * @version 2018-01-08
 */
public class ZImportTableColumn extends DataEntity<ZImportTableColumn> {
	
	private static final long serialVersionUID = 1L;
	private String fieldName;		// 字段名称
	private String excelColumn;		// excel列
	private String columnType;		// 字段类型
	private String dbColumn;		// 数据库字段名称
	private String dateFormatter;		// 日期格式化
	private String tableId;		// 表ID
	private String tableName;		// 表名称
	
	public ZImportTableColumn() {
		super();
	}

	public ZImportTableColumn(String id){
		super(id);
	}

	@Length(min=0, max=50, message="字段名称长度必须介于 0 和 50 之间")
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	@Length(min=0, max=50, message="excel列长度必须介于 0 和 50 之间")
	public String getExcelColumn() {
		return excelColumn;
	}

	public void setExcelColumn(String excelColumn) {
		this.excelColumn = excelColumn;
	}
	
	@Length(min=0, max=50, message="字段类型长度必须介于 0 和 50 之间")
	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	
	@Length(min=0, max=50, message="数据库字段名称长度必须介于 0 和 50 之间")
	public String getDbColumn() {
		return dbColumn;
	}

	public void setDbColumn(String dbColumn) {
		this.dbColumn = dbColumn;
	}
	
	@Length(min=0, max=50, message="日期格式化长度必须介于 0 和 50 之间")
	public String getDateFormatter() {
		return dateFormatter;
	}

	public void setDateFormatter(String dateFormatter) {
		this.dateFormatter = dateFormatter;
	}
	
	@Length(min=0, max=64, message="表ID长度必须介于 0 和 64 之间")
	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	
	@Length(min=0, max=50, message="表名称长度必须介于 0 和 50 之间")
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}