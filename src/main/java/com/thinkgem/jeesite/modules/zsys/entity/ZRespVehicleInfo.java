/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 责任经营车辆信息查询Entity
 * @author tom
 * @version 2017-12-13
 */
public class ZRespVehicleInfo extends DataEntity<ZRespVehicleInfo> {
	
	private static final long serialVersionUID = 1L;
	private Date actualOnlineOperationTime;		// 实际上线运营时间
	private Date operationCertificateExpireDate;		// 营运证截止日期
	private Date operationCertificateIssueDate;		// 营运证发证日期
	private String operationCertificateNum;		// 营运证号
	private String engineNum;		// 发动机号
	private String frameNum;		// 车架号
	private Date vehicleProductionDate;		// 车辆出厂日期
	private String taximeterNum;		// 计价器编号
	private String vehicleType;		// 车辆型号
	private String name;		// 姓名
	private String newVehicleNum;		// 新车号
	private String oriVehicleNum;		// 原车号
	
	public ZRespVehicleInfo() {
		super();
	}

	public ZRespVehicleInfo(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getActualOnlineOperationTime() {
		return actualOnlineOperationTime;
	}

	public void setActualOnlineOperationTime(Date actualOnlineOperationTime) {
		this.actualOnlineOperationTime = actualOnlineOperationTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOperationCertificateExpireDate() {
		return operationCertificateExpireDate;
	}

	public void setOperationCertificateExpireDate(Date operationCertificateExpireDate) {
		this.operationCertificateExpireDate = operationCertificateExpireDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOperationCertificateIssueDate() {
		return operationCertificateIssueDate;
	}

	public void setOperationCertificateIssueDate(Date operationCertificateIssueDate) {
		this.operationCertificateIssueDate = operationCertificateIssueDate;
	}
	
	@Length(min=0, max=50, message="营运证号长度必须介于 0 和 50 之间")
	public String getOperationCertificateNum() {
		return operationCertificateNum;
	}

	public void setOperationCertificateNum(String operationCertificateNum) {
		this.operationCertificateNum = operationCertificateNum;
	}
	
	@Length(min=0, max=50, message="发动机号长度必须介于 0 和 50 之间")
	public String getEngineNum() {
		return engineNum;
	}

	public void setEngineNum(String engineNum) {
		this.engineNum = engineNum;
	}
	
	@Length(min=0, max=50, message="车架号长度必须介于 0 和 50 之间")
	public String getFrameNum() {
		return frameNum;
	}

	public void setFrameNum(String frameNum) {
		this.frameNum = frameNum;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getVehicleProductionDate() {
		return vehicleProductionDate;
	}

	public void setVehicleProductionDate(Date vehicleProductionDate) {
		this.vehicleProductionDate = vehicleProductionDate;
	}
	
	@Length(min=0, max=50, message="计价器编号长度必须介于 0 和 50 之间")
	public String getTaximeterNum() {
		return taximeterNum;
	}

	public void setTaximeterNum(String taximeterNum) {
		this.taximeterNum = taximeterNum;
	}
	
	@Length(min=0, max=50, message="车辆型号长度必须介于 0 和 50 之间")
	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	@Length(min=0, max=50, message="姓名长度必须介于 0 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=50, message="新车号长度必须介于 0 和 50 之间")
	public String getNewVehicleNum() {
		return newVehicleNum;
	}

	public void setNewVehicleNum(String newVehicleNum) {
		this.newVehicleNum = newVehicleNum;
	}
	
	@Length(min=0, max=50, message="原车号长度必须介于 0 和 50 之间")
	public String getOriVehicleNum() {
		return oriVehicleNum;
	}

	public void setOriVehicleNum(String oriVehicleNum) {
		this.oriVehicleNum = oriVehicleNum;
	}
	
}