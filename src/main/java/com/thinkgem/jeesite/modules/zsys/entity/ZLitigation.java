/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 诉讼案件查询Entity
 * @author tom
 * @version 2017-12-17
 */
public class ZLitigation extends DataEntity<ZLitigation> {
	
	private static final long serialVersionUID = 1L;
	private String vehicleNum;		// 车号
	private Date accTime;		// 事故时间
	private String litCause;		// 诉讼案由（标明伤人、死亡、财产损失）
	private Date litTime;		// 诉讼时间
	private String litTarget;		// 诉讼标的
	private String judgmentAmount;		// 判决金额
	private String insuranceCompany;		// 保险公司名称
	private String insurancePayment;		// 保险支付
	private String operatorPayment;		// 责任经营者支付
	private Date closeTime;		// 结案时间
	private String court;		// 诉讼法院
	private String mark;		// 备注
	private String driverLicense;		// 驾照
	private String queryCode;		// 查询码
	private Date beginAccTime;		// 开始 事故时间
	private Date endAccTime;		// 结束 事故时间
	private Date beginLitTime;		// 开始 诉讼时间
	private Date endLitTime;		// 结束 诉讼时间
	
	private String frameNum;
	private String judgmentNum;
	private Date handleDate;
	
	public ZLitigation() {
		super();
	}

	public ZLitigation(String id){
		super(id);
	}

	
	@Length(min=0, max=50, message="车架号长度必须介于 0 和 50 之间")
	public String getFrameNum() {
		return frameNum;
	}

	public void setFrameNum(String frameNum) {
		this.frameNum = frameNum;
	}
	@Length(min=0, max=50, message="判决编号长度必须介于 0 和 50 之间")
	public String getJudgmentNum() {
		return judgmentNum;
	}

	public void setJudgmentNum(String judgmentNum) {
		this.judgmentNum = judgmentNum;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}

	@Length(min=0, max=50, message="车号长度必须介于 0 和 50 之间")
	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAccTime() {
		return accTime;
	}

	public void setAccTime(Date accTime) {
		this.accTime = accTime;
	}
	
	@Length(min=0, max=255, message="诉讼案由（标明伤人、死亡、财产损失）长度必须介于 0 和 255 之间")
	public String getLitCause() {
		return litCause;
	}

	public void setLitCause(String litCause) {
		this.litCause = litCause;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLitTime() {
		return litTime;
	}

	public void setLitTime(Date litTime) {
		this.litTime = litTime;
	}
	
	@Length(min=0, max=255, message="诉讼标的长度必须介于 0 和 255 之间")
	public String getLitTarget() {
		return litTarget;
	}

	public void setLitTarget(String litTarget) {
		this.litTarget = litTarget;
	}
	
	@Length(min=0, max=50, message="判决金额长度必须介于 0 和 50 之间")
	public String getJudgmentAmount() {
		return judgmentAmount;
	}

	public void setJudgmentAmount(String judgmentAmount) {
		this.judgmentAmount = judgmentAmount;
	}
	
	@Length(min=0, max=50, message="保险公司名称长度必须介于 0 和 50 之间")
	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	
	@Length(min=0, max=50, message="保险支付长度必须介于 0 和 50 之间")
	public String getInsurancePayment() {
		return insurancePayment;
	}

	public void setInsurancePayment(String insurancePayment) {
		this.insurancePayment = insurancePayment;
	}
	
	@Length(min=0, max=50, message="责任经营者支付长度必须介于 0 和 50 之间")
	public String getOperatorPayment() {
		return operatorPayment;
	}

	public void setOperatorPayment(String operatorPayment) {
		this.operatorPayment = operatorPayment;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	
	@Length(min=0, max=50, message="诉讼法院长度必须介于 0 和 50 之间")
	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}
	
	@Length(min=0, max=50, message="备注长度必须介于 0 和 50 之间")
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
	
	public Date getBeginAccTime() {
		return beginAccTime;
	}

	public void setBeginAccTime(Date beginAccTime) {
		this.beginAccTime = beginAccTime;
	}
	
	public Date getEndAccTime() {
		return endAccTime;
	}

	public void setEndAccTime(Date endAccTime) {
		this.endAccTime = endAccTime;
	}
		
	public Date getBeginLitTime() {
		return beginLitTime;
	}

	public void setBeginLitTime(Date beginLitTime) {
		this.beginLitTime = beginLitTime;
	}
	
	public Date getEndLitTime() {
		return endLitTime;
	}

	public void setEndLitTime(Date endLitTime) {
		this.endLitTime = endLitTime;
	}
		
}