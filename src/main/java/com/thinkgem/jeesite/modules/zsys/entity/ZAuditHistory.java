/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 前台日志Entity
 * @author tom
 * @version 2018-01-02
 */
public class ZAuditHistory extends DataEntity<ZAuditHistory> {
	
	private static final long serialVersionUID = 1L;
	private String moduleName;		// 模块名称
	private String visitIp;		// 访问IP
	
	public ZAuditHistory() {
		super();
	}

	public ZAuditHistory(String id){
		super(id);
	}

	@Length(min=0, max=50, message="模块名称长度必须介于 0 和 50 之间")
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	@Length(min=0, max=50, message="访问IP长度必须介于 0 和 50 之间")
	public String getVisitIp() {
		return visitIp;
	}

	public void setVisitIp(String visitIp) {
		this.visitIp = visitIp;
	}
	
}