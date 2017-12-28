/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 交通事故查询Entity
 * @author tom
 * @version 2017-12-17
 */
public class ZAccident extends DataEntity<ZAccident> {
	
	private static final long serialVersionUID = 1L;
	private Date accTime;		// 事故时间
	private String accAddress;		// 事故地点
	private String respSituation;		// 责任情况
	private String level;		// 事故等级
	private String accReasonType;		// 事故原因、种类
	private String vehicleInsuranceCompany;		// 车辆承保公司
	private String estimationAmount;		// 预估损失金额（元）
	private String injuredCount;		// 受伤人数
	private String deathCount;		// 死亡人数
	private String caseProgress;		// 案件进展情况
	private String claimAmount;		// 保险理赔金额（元）
	private Date closeDate;		// 结案日期
	private String mark;		// 备注
	private String accVehcileNum;		// 事故车号
	private String driverName;		// 驾驶员姓名
	private String accidentNum;		// 事故编号
	private String selfNum;		// 自编号
	private String driverLicense;		// 驾照
	private String queryCode;		// 查询码
	private Date beginAccTime;		// 开始 事故时间
	private Date endAccTime;		// 结束 事故时间
	private Date beginCloseDate;		// 开始 结案日期
	private Date endCloseDate;		// 结束 结案日期
	private String step;
	private String nodeName;
	private String processId;
	private String nodeId;
	
	public ZAccident() {
		super();
	}

	public ZAccident(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAccTime() {
		return accTime;
	}

	public void setAccTime(Date accTime) {
		this.accTime = accTime;
	}
	
	@Length(min=0, max=50, message="事故地点长度必须介于 0 和 50 之间")
	public String getAccAddress() {
		return accAddress;
	}

	public void setAccAddress(String accAddress) {
		this.accAddress = accAddress;
	}
	
	@Length(min=0, max=50, message="责任情况长度必须介于 0 和 50 之间")
	public String getRespSituation() {
		return respSituation;
	}

	public void setRespSituation(String respSituation) {
		this.respSituation = respSituation;
	}
	
	@Length(min=0, max=50, message="事故等级长度必须介于 0 和 50 之间")
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	@Length(min=0, max=50, message="事故原因、种类长度必须介于 0 和 50 之间")
	public String getAccReasonType() {
		return accReasonType;
	}

	public void setAccReasonType(String accReasonType) {
		this.accReasonType = accReasonType;
	}
	
	@Length(min=0, max=50, message="车辆承保公司长度必须介于 0 和 50 之间")
	public String getVehicleInsuranceCompany() {
		return vehicleInsuranceCompany;
	}

	public void setVehicleInsuranceCompany(String vehicleInsuranceCompany) {
		this.vehicleInsuranceCompany = vehicleInsuranceCompany;
	}
	
	@Length(min=0, max=50, message="预估损失金额（元）长度必须介于 0 和 50 之间")
	public String getEstimationAmount() {
		return estimationAmount;
	}

	public void setEstimationAmount(String estimationAmount) {
		this.estimationAmount = estimationAmount;
	}
	
	@Length(min=0, max=50, message="受伤人数长度必须介于 0 和 50 之间")
	public String getInjuredCount() {
		return injuredCount;
	}

	public void setInjuredCount(String injuredCount) {
		this.injuredCount = injuredCount;
	}
	
	@Length(min=0, max=50, message="死亡人数长度必须介于 0 和 50 之间")
	public String getDeathCount() {
		return deathCount;
	}

	public void setDeathCount(String deathCount) {
		this.deathCount = deathCount;
	}
	
	@Length(min=0, max=255, message="案件进展情况长度必须介于 0 和 255 之间")
	public String getCaseProgress() {
		return caseProgress;
	}

	public void setCaseProgress(String caseProgress) {
		this.caseProgress = caseProgress;
	}
	
	@Length(min=0, max=50, message="保险理赔金额（元）长度必须介于 0 和 50 之间")
	public String getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	
	@Length(min=0, max=255, message="备注长度必须介于 0 和 255 之间")
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	@Length(min=0, max=50, message="事故车号长度必须介于 0 和 50 之间")
	public String getAccVehcileNum() {
		return accVehcileNum;
	}

	public void setAccVehcileNum(String accVehcileNum) {
		this.accVehcileNum = accVehcileNum;
	}
	
	@Length(min=0, max=50, message="驾驶员姓名长度必须介于 0 和 50 之间")
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	@Length(min=0, max=50, message="事故编号长度必须介于 0 和 50 之间")
	public String getAccidentNum() {
		return accidentNum;
	}

	public void setAccidentNum(String accidentNum) {
		this.accidentNum = accidentNum;
	}
	
	@Length(min=0, max=50, message="自编号长度必须介于 0 和 50 之间")
	public String getSelfNum() {
		return selfNum;
	}

	public void setSelfNum(String selfNum) {
		this.selfNum = selfNum;
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
		
	public Date getBeginCloseDate() {
		return beginCloseDate;
	}

	public void setBeginCloseDate(Date beginCloseDate) {
		this.beginCloseDate = beginCloseDate;
	}
	
	public Date getEndCloseDate() {
		return endCloseDate;
	}

	public void setEndCloseDate(Date endCloseDate) {
		this.endCloseDate = endCloseDate;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
	
		
}