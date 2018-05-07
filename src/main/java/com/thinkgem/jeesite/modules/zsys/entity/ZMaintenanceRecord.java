/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 车辆技术维护记录查询Entity
 * @author tom
 * @version 2017-12-18
 */
public class ZMaintenanceRecord extends DataEntity<ZMaintenanceRecord> {
	
	private static final long serialVersionUID = 1L;
	private String selfNum;		// 自编号
	private String vehicleNum;		// 车牌号
	private String operator;		// 经营者
	private String firstQuarter;		// 一季度
	private String secondQuarter;		// 二季度
	private String thirdQuarter;		// 三季度
	private String fourthQuarter;		// 四季度
	private Date inspectionTime;		// 车辆年检时间
	private String mark;		// 备注
	private String driverLicense;		// 驾照
	private String queryCode;		// 查询码
	private Date beginInspectionTime;		// 开始 车辆年检时间
	private Date endInspectionTime;		// 结束 车辆年检时间
	private String inspectionDate;
	private String frameNum;
	
	public ZMaintenanceRecord() {
		super();
	}

	public ZMaintenanceRecord(String id){
		super(id);
	}

	
	@Length(min=0, max=50, message="车辆年检时间长度必须介于 0 和 50 之间")
	public String getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(String inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	@Length(min=0, max=50, message="车架号码长度必须介于 0 和 50 之间")
	public String getFrameNum() {
		return frameNum;
	}

	public void setFrameNum(String frameNum) {
		this.frameNum = frameNum;
	}

	@Length(min=0, max=50, message="自编号长度必须介于 0 和 50 之间")
	public String getSelfNum() {
		return selfNum;
	}

	public void setSelfNum(String selfNum) {
		this.selfNum = selfNum;
	}
	
	@Length(min=0, max=50, message="车牌号长度必须介于 0 和 50 之间")
	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	
	@Length(min=0, max=50, message="经营者长度必须介于 0 和 50 之间")
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	@Length(min=0, max=50, message="一季度长度必须介于 0 和 50 之间")
	public String getFirstQuarter() {
		return firstQuarter;
	}

	public void setFirstQuarter(String firstQuarter) {
		this.firstQuarter = firstQuarter;
	}
	
	@Length(min=0, max=50, message="二季度长度必须介于 0 和 50 之间")
	public String getSecondQuarter() {
		return secondQuarter;
	}

	public void setSecondQuarter(String secondQuarter) {
		this.secondQuarter = secondQuarter;
	}
	
	@Length(min=0, max=50, message="三季度长度必须介于 0 和 50 之间")
	public String getThirdQuarter() {
		return thirdQuarter;
	}

	public void setThirdQuarter(String thirdQuarter) {
		this.thirdQuarter = thirdQuarter;
	}
	
	@Length(min=0, max=50, message="四季度长度必须介于 0 和 50 之间")
	public String getFourthQuarter() {
		return fourthQuarter;
	}

	public void setFourthQuarter(String fourthQuarter) {
		this.fourthQuarter = fourthQuarter;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInspectionTime() {
		return inspectionTime;
	}

	public void setInspectionTime(Date inspectionTime) {
		this.inspectionTime = inspectionTime;
	}
	
	@Length(min=0, max=255, message="备注长度必须介于 0 和 255 之间")
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	@Length(min=0, max=50, message="驾照长度必须介于 0 和 50 之间")
	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}
	
	@Length(min=0, max=50, message="查询码长度必须介于 0 和 50 之间")
	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}
	
	public Date getBeginInspectionTime() {
		return beginInspectionTime;
	}

	public void setBeginInspectionTime(Date beginInspectionTime) {
		this.beginInspectionTime = beginInspectionTime;
	}
	
	public Date getEndInspectionTime() {
		return endInspectionTime;
	}

	public void setEndInspectionTime(Date endInspectionTime) {
		this.endInspectionTime = endInspectionTime;
	}
		
}