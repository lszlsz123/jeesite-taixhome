package com.thinkgem.jeesite.modules.zsys.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class ZStatistics extends DataEntity<ZStatistics>{

	private String searchTableName;
	
	private String whereCondition;
	
	private String SQL;

	public String getSearchTableName() {
		return searchTableName;
	}

	public void setSearchTableName(String searchTableName) {
		this.searchTableName = searchTableName;
	}

	public String getWhereCondition() {
		return whereCondition;
	}

	public void setWhereCondition(String whereCondition) {
		this.whereCondition = whereCondition;
	}

	public String getSQL() {
		return SQL;
	}

	public void setSQL(String sQL) {
		SQL = sQL;
	}
	
	
	
}
