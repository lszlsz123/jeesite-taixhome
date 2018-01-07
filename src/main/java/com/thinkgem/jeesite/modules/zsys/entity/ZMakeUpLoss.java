/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import java.util.Date;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 证件遗失补办业务Entity
 * @author tom
 * @version 2018-01-02
 */
public class ZMakeUpLoss extends DataEntity<ZMakeUpLoss> {
	
	private static final long serialVersionUID = 1L;
	private String vehicleNum;		// 车牌号码
	private String queryCode;		// 查询码
	private Date lossTime;		// 丢失时间
	private String certType;		// 证件类型
	private String type;		// 办理事件类型
	private Date beginCreateDate;		// 开始 创建日期
	private Date endCreateDate;		// 结束 创建日期
	private Date beginUpdateDate;		// 开始 更新日期
	private Date endUpdateDate;		// 结束 更新日期
	
	public ZMakeUpLoss() {
		super();
	}

	public ZMakeUpLoss(String id){
		super(id);
	}

	@Length(min=0, max=50, message="车牌号码长度必须介于 0 和 50 之间")
	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	
	@Length(min=0, max=50, message="查询码长度必须介于 0 和 50 之间")
	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLossTime() {
		return lossTime;
	}

	public void setLossTime(Date lossTime) {
		this.lossTime = lossTime;
	}
	
	@Length(min=0, max=50, message="证件类型长度必须介于 0 和 50 之间")
	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}
	
	@Length(min=0, max=50, message="办理事件类型长度必须介于 0 和 50 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Date getBeginCreateDate() {
		return beginCreateDate;
	}

	public void setBeginCreateDate(Date beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}
	
	public Date getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}
		
	public Date getBeginUpdateDate() {
		return beginUpdateDate;
	}

	public void setBeginUpdateDate(Date beginUpdateDate) {
		this.beginUpdateDate = beginUpdateDate;
	}
	
	public Date getEndUpdateDate() {
		return endUpdateDate;
	}

	public void setEndUpdateDate(Date endUpdateDate) {
		this.endUpdateDate = endUpdateDate;
	}
		
}