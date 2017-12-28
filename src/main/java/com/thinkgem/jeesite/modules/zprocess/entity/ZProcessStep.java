/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 流程操作节点记录Entity
 * @author tom
 * @version 2017-12-24
 */
public class ZProcessStep extends DataEntity<ZProcessStep> {
	
	private static final long serialVersionUID = 1L;
	private String accId;		// 事故编号
	private String nodeId;		// 流程节点名称
	private String nodeName;		// 节点名称
	private String stepSeq;		// 序号
	
	public ZProcessStep() {
		super();
	}

	public ZProcessStep(String id){
		super(id);
	}

	@Length(min=0, max=64, message="事故编号长度必须介于 0 和 64 之间")
	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}
	
	@Length(min=0, max=64, message="流程节点名称长度必须介于 0 和 64 之间")
	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
	@Length(min=0, max=50, message="节点名称长度必须介于 0 和 50 之间")
	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	@Length(min=0, max=11, message="序号长度必须介于 0 和 11 之间")
	public String getStepSeq() {
		return stepSeq;
	}

	public void setStepSeq(String stepSeq) {
		this.stepSeq = stepSeq;
	}
	
}