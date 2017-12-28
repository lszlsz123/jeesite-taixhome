/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 保险理赔业务查询Entity
 * @author tom
 * @version 2017-12-17
 */
public class ZInsuranceClaimSettlement extends DataEntity<ZInsuranceClaimSettlement> {
	
	private static final long serialVersionUID = 1L;
	private String accNum;		// 事故编号
	private String selfNum;		// 自编号
	private String vehicleNum;		// 车牌号
	private Date accTime;		// 肇事时间
	private String individualVehicleOperator;		// 单车经营者
	private String accidentAddress;		// 肇事地点
	private String respSituation;		// 责任情况
	private String accDriver;		// 肇事司机
	private String accReason;		// 肇事原因
	private String vehicleIndemnity;		// 交强险（车）赔款
	private String humanInjuryIndemnity;		// 交强险（人伤）赔款
	private String lossIndemnity;		// 车损险赔款
	private String thirdPartyVehicleIndemnity;		// 三者险（车）赔款
	private String thirdPartyHumanInjuryIndemnity;		// 三者险（人）赔款
	private String carrierInsuranceIndemnity;		// 承运人险赔款
	private String totalAmount;		// 赔款总金额
	private Date closingDate;		// 结案日期
	private Date companyRealseTime;		// 公司发放时间
	private String mark;		// 备注
	private String driverLicense;		// 驾照
	private String queryCode;		// 查询码
	private Date beginAccTime;		// 开始 肇事时间
	private Date endAccTime;		// 结束 肇事时间
	private Date beginClosingDate;		// 开始 结案日期
	private Date endClosingDate;		// 结束 结案日期
	
	public ZInsuranceClaimSettlement() {
		super();
	}

	public ZInsuranceClaimSettlement(String id){
		super(id);
	}

	@Length(min=0, max=50, message="事故编号长度必须介于 0 和 50 之间")
	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAccTime() {
		return accTime;
	}

	public void setAccTime(Date accTime) {
		this.accTime = accTime;
	}
	
	@Length(min=0, max=50, message="单车经营者长度必须介于 0 和 50 之间")
	public String getIndividualVehicleOperator() {
		return individualVehicleOperator;
	}

	public void setIndividualVehicleOperator(String individualVehicleOperator) {
		this.individualVehicleOperator = individualVehicleOperator;
	}
	
	@Length(min=0, max=50, message="肇事地点长度必须介于 0 和 50 之间")
	public String getAccidentAddress() {
		return accidentAddress;
	}

	public void setAccidentAddress(String accidentAddress) {
		this.accidentAddress = accidentAddress;
	}
	
	@Length(min=0, max=50, message="责任情况长度必须介于 0 和 50 之间")
	public String getRespSituation() {
		return respSituation;
	}

	public void setRespSituation(String respSituation) {
		this.respSituation = respSituation;
	}
	
	@Length(min=0, max=50, message="肇事司机长度必须介于 0 和 50 之间")
	public String getAccDriver() {
		return accDriver;
	}

	public void setAccDriver(String accDriver) {
		this.accDriver = accDriver;
	}
	
	@Length(min=0, max=255, message="肇事原因长度必须介于 0 和 255 之间")
	public String getAccReason() {
		return accReason;
	}

	public void setAccReason(String accReason) {
		this.accReason = accReason;
	}
	
	@Length(min=0, max=50, message="交强险（车）赔款长度必须介于 0 和 50 之间")
	public String getVehicleIndemnity() {
		return vehicleIndemnity;
	}

	public void setVehicleIndemnity(String vehicleIndemnity) {
		this.vehicleIndemnity = vehicleIndemnity;
	}
	
	@Length(min=0, max=50, message="交强险（人伤）赔款长度必须介于 0 和 50 之间")
	public String getHumanInjuryIndemnity() {
		return humanInjuryIndemnity;
	}

	public void setHumanInjuryIndemnity(String humanInjuryIndemnity) {
		this.humanInjuryIndemnity = humanInjuryIndemnity;
	}
	
	@Length(min=0, max=50, message="车损险赔款长度必须介于 0 和 50 之间")
	public String getLossIndemnity() {
		return lossIndemnity;
	}

	public void setLossIndemnity(String lossIndemnity) {
		this.lossIndemnity = lossIndemnity;
	}
	
	@Length(min=0, max=50, message="三者险（车）赔款长度必须介于 0 和 50 之间")
	public String getThirdPartyVehicleIndemnity() {
		return thirdPartyVehicleIndemnity;
	}

	public void setThirdPartyVehicleIndemnity(String thirdPartyVehicleIndemnity) {
		this.thirdPartyVehicleIndemnity = thirdPartyVehicleIndemnity;
	}
	
	@Length(min=0, max=50, message="三者险（人）赔款长度必须介于 0 和 50 之间")
	public String getThirdPartyHumanInjuryIndemnity() {
		return thirdPartyHumanInjuryIndemnity;
	}

	public void setThirdPartyHumanInjuryIndemnity(String thirdPartyHumanInjuryIndemnity) {
		this.thirdPartyHumanInjuryIndemnity = thirdPartyHumanInjuryIndemnity;
	}
	
	@Length(min=0, max=50, message="承运人险赔款长度必须介于 0 和 50 之间")
	public String getCarrierInsuranceIndemnity() {
		return carrierInsuranceIndemnity;
	}

	public void setCarrierInsuranceIndemnity(String carrierInsuranceIndemnity) {
		this.carrierInsuranceIndemnity = carrierInsuranceIndemnity;
	}
	
	@Length(min=0, max=50, message="赔款总金额长度必须介于 0 和 50 之间")
	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCompanyRealseTime() {
		return companyRealseTime;
	}

	public void setCompanyRealseTime(Date companyRealseTime) {
		this.companyRealseTime = companyRealseTime;
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
		
	public Date getBeginClosingDate() {
		return beginClosingDate;
	}

	public void setBeginClosingDate(Date beginClosingDate) {
		this.beginClosingDate = beginClosingDate;
	}
	
	public Date getEndClosingDate() {
		return endClosingDate;
	}

	public void setEndClosingDate(Date endClosingDate) {
		this.endClosingDate = endClosingDate;
	}
		
}