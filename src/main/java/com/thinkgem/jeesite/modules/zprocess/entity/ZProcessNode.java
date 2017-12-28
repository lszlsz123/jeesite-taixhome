/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 流程节点管理Entity
 * @author tom
 * @version 2017-12-24
 */
public class ZProcessNode extends DataEntity<ZProcessNode> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 节点名称
	
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
	
	public String getValue() {
		return this.id;
	}
	
	public String getLabel() {
		return this.name;
	}
	
}