/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 从业司机业务办理查询Entity
 * @author tom
 * @version 2017-12-14
 */
public class ZDriverBusiness extends DataEntity<ZDriverBusiness> {
	
	private static final long serialVersionUID = 1L;
	private String vehicleType;		// 车型
	private String selfNumber;		// 自编号
	private String vehicleNum;		// 车牌
	private String driver;		// 备班驾驶员
	private String contactPhone;		// 联系电话
	private String idCard;		// 身份证号
	private String address;		// 地址
	private String allowedDriveModel;		// 准驾车型
	private Date licenseInitialDate;		// 驾照初领日期
	private String quaCertNum;		// 从业资格证号
	private Date quaCertInitialDate;		// 从业资格证初领日期
	private Date driverDate;		// 备班日期
	private Date quitDate;		// 退出日期
	private String step;		// 审批流程
	private String queryCode;		// 查询号码
	private Date beginDriverDate;		// 开始 备班日期
	private Date endDriverDate;		// 结束 备班日期
	private Date beginQuitDate;		// 开始 退出日期
	private Date endQuitDate;		// 结束 退出日期
	
	public ZDriverBusiness() {
		super();
	}

	public ZDriverBusiness(String id){
		super(id);
	}

	@Length(min=0, max=50, message="车型长度必须介于 0 和 50 之间")
	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	@Length(min=0, max=50, message="自编号长度必须介于 0 和 50 之间")
	public String getSelfNumber() {
		return selfNumber;
	}

	public void setSelfNumber(String selfNumber) {
		this.selfNumber = selfNumber;
	}
	
	@Length(min=0, max=50, message="车牌长度必须介于 0 和 50 之间")
	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	
	@Length(min=0, max=50, message="备班驾驶员长度必须介于 0 和 50 之间")
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	@Length(min=0, max=50, message="联系电话长度必须介于 0 和 50 之间")
	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	@Length(min=0, max=50, message="身份证号长度必须介于 0 和 50 之间")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Length(min=0, max=50, message="地址长度必须介于 0 和 50 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=50, message="准驾车型长度必须介于 0 和 50 之间")
	public String getAllowedDriveModel() {
		return allowedDriveModel;
	}

	public void setAllowedDriveModel(String allowedDriveModel) {
		this.allowedDriveModel = allowedDriveModel;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLicenseInitialDate() {
		return licenseInitialDate;
	}

	public void setLicenseInitialDate(Date licenseInitialDate) {
		this.licenseInitialDate = licenseInitialDate;
	}
	
	@Length(min=0, max=50, message="从业资格证号长度必须介于 0 和 50 之间")
	public String getQuaCertNum() {
		return quaCertNum;
	}

	public void setQuaCertNum(String quaCertNum) {
		this.quaCertNum = quaCertNum;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getQuaCertInitialDate() {
		return quaCertInitialDate;
	}

	public void setQuaCertInitialDate(Date quaCertInitialDate) {
		this.quaCertInitialDate = quaCertInitialDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDriverDate() {
		return driverDate;
	}

	public void setDriverDate(Date driverDate) {
		this.driverDate = driverDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getQuitDate() {
		return quitDate;
	}

	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}
	
	@Length(min=0, max=50, message="审批流程长度必须介于 0 和 50 之间")
	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}
	
	@Length(min=0, max=50, message="查询号码长度必须介于 0 和 50 之间")
	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}
	
	public Date getBeginDriverDate() {
		return beginDriverDate;
	}

	public void setBeginDriverDate(Date beginDriverDate) {
		this.beginDriverDate = beginDriverDate;
	}
	
	public Date getEndDriverDate() {
		return endDriverDate;
	}

	public void setEndDriverDate(Date endDriverDate) {
		this.endDriverDate = endDriverDate;
	}
		
	public Date getBeginQuitDate() {
		return beginQuitDate;
	}

	public void setBeginQuitDate(Date beginQuitDate) {
		this.beginQuitDate = beginQuitDate;
	}
	
	public Date getEndQuitDate() {
		return endQuitDate;
	}

	public void setEndQuitDate(Date endQuitDate) {
		this.endQuitDate = endQuitDate;
	}
		
}