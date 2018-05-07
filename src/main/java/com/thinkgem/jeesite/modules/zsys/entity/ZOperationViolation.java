/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 运营违规记录查询Entity
 * @author tom
 * @version 2017-12-28
 */
public class ZOperationViolation extends DataEntity<ZOperationViolation> {
	
	private static final long serialVersionUID = 1L;
	private Date complaintTime;		// 投诉时间
	private String complaintType;		// 投诉类型
	private String complaintPerson;		// 投诉人
	private String complaintPhoneNum;		// 投诉电话
	private String operator;		// 经营者
	private String operatorPhoneNum;		// 经营者电话
	private String driver;		// 驾驶员
	private String driverPhoneNum;		// 驾驶员电话
	private String vehicleNum;		// 车牌号
	private String procedureContent;		// 事情经过
	private String result;		// 处理结果
	private String processingPerson;		// 处理人
	private Date beginComplaintTime;		// 开始 投诉时间
	private Date endComplaintTime;		// 结束 投诉时间
	private String frameNum; //车架号
	private String queryCode;//查询码
	private Date handleDate;
	
	public ZOperationViolation() {
		super();
	}

	public ZOperationViolation(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getComplaintTime() {
		return complaintTime;
	}

	public void setComplaintTime(Date complaintTime) {
		this.complaintTime = complaintTime;
	}
	
	@Length(min=0, max=50, message="投诉类型长度必须介于 0 和 50 之间")
	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	
	@Length(min=0, max=50, message="投诉人长度必须介于 0 和 50 之间")
	public String getComplaintPerson() {
		return complaintPerson;
	}

	public void setComplaintPerson(String complaintPerson) {
		this.complaintPerson = complaintPerson;
	}
	
	@Length(min=0, max=50, message="投诉电话长度必须介于 0 和 50 之间")
	public String getComplaintPhoneNum() {
		return complaintPhoneNum;
	}

	public void setComplaintPhoneNum(String complaintPhoneNum) {
		this.complaintPhoneNum = complaintPhoneNum;
	}
	
	@Length(min=0, max=50, message="经营者长度必须介于 0 和 50 之间")
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	@Length(min=0, max=50, message="经营者电话长度必须介于 0 和 50 之间")
	public String getOperatorPhoneNum() {
		return operatorPhoneNum;
	}

	public void setOperatorPhoneNum(String operatorPhoneNum) {
		this.operatorPhoneNum = operatorPhoneNum;
	}
	
	@Length(min=0, max=50, message="驾驶员长度必须介于 0 和 50 之间")
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	@Length(min=0, max=50, message="驾驶员电话长度必须介于 0 和 50 之间")
	public String getDriverPhoneNum() {
		return driverPhoneNum;
	}

	public void setDriverPhoneNum(String driverPhoneNum) {
		this.driverPhoneNum = driverPhoneNum;
	}
	
	@Length(min=0, max=50, message="车牌号长度必须介于 0 和 50 之间")
	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	
	@Length(min=0, max=255, message="事情经过长度必须介于 0 和 255 之间")
	public String getProcedureContent() {
		return procedureContent;
	}

	public void setProcedureContent(String procedureContent) {
		this.procedureContent = procedureContent;
	}
	
	@Length(min=0, max=255, message="处理结果长度必须介于 0 和 255 之间")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	@Length(min=0, max=50, message="处理人长度必须介于 0 和 50 之间")
	public String getProcessingPerson() {
		return processingPerson;
	}

	public void setProcessingPerson(String processingPerson) {
		this.processingPerson = processingPerson;
	}
	
	public Date getBeginComplaintTime() {
		return beginComplaintTime;
	}

	public void setBeginComplaintTime(Date beginComplaintTime) {
		this.beginComplaintTime = beginComplaintTime;
	}
	
	public Date getEndComplaintTime() {
		return endComplaintTime;
	}

	public void setEndComplaintTime(Date endComplaintTime) {
		this.endComplaintTime = endComplaintTime;
	}

	@Length(min=0, max=50, message="长度必须介于 0 和 50 之间")
	public String getFrameNum() {
		return frameNum;
	}

	public void setFrameNum(String frameNum) {
		this.frameNum = frameNum;
	}

	@Length(min=0, max=50, message="长度必须介于 0 和 50 之间")
	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}
	
	
	
		
}