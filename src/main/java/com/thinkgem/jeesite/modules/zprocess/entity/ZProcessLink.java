/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 流程步骤管理Entity
 * @author tom
 * @version 2017-12-24
 */
public class ZProcessLink extends DataEntity<ZProcessLink> {
	
	private static final long serialVersionUID = 1L;
	private String startNode;		// 开始节点
	private String endNode;		// 结束节点
	private String startName;		// 开始节点名称
	private String endName;		// 结束节点名称
	private String processId;		// 流程ID
	private String processName;		// 流程名称
	
	public ZProcessLink() {
		super();
	}

	public ZProcessLink(String id){
		super(id);
	}

	@Length(min=0, max=64, message="开始节点长度必须介于 0 和 64 之间")
	public String getStartNode() {
		return startNode;
	}

	public void setStartNode(String startNode) {
		this.startNode = startNode;
	}
	
	@Length(min=0, max=64, message="结束节点长度必须介于 0 和 64 之间")
	public String getEndNode() {
		return endNode;
	}

	public void setEndNode(String endNode) {
		this.endNode = endNode;
	}
	
	@Length(min=0, max=50, message="开始节点名称长度必须介于 0 和 50 之间")
	public String getStartName() {
		return startName;
	}

	public void setStartName(String startName) {
		this.startName = startName;
	}
	
	@Length(min=0, max=50, message="结束节点名称长度必须介于 0 和 50 之间")
	public String getEndName() {
		return endName;
	}

	public void setEndName(String endName) {
		this.endName = endName;
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
	
}