/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 流程节点管理Entity
 * @author tom
 * @version 2018-01-07
 */
public class ZProcessNode extends DataEntity<ZProcessNode> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 节点名称
	private String processId;		// 流程ID
	private String processName;		// 流程名称
	private String seq;		// 排序
	private String checkedFlag = "0"; //是否已经选择 1选择，0没有选择
	
	public ZProcessNode() {
		super();
	}

	public ZProcessNode(String id){
		super(id);
	}

	@Length(min=0, max=50, message="节点名称长度必须介于 0 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=64, message="流程ID长度必须介于 0 和 64 之间")
	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}
	
	@Length(min=0, max=50, message="流程名称长度必须介于 0 和 50 之间")
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	@Length(min=0, max=11, message="排序长度必须介于 0 和 11 之间")
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getCheckedFlag() {
		return checkedFlag;
	}

	public void setCheckedFlag(String checkedFlag) {
		this.checkedFlag = checkedFlag;
	}
	
	
	
}