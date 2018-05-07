/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 车辆投保情况查询Entity
 * @author tom
 * @version 2017-12-17
 */
public class ZVehicleInsurance extends DataEntity<ZVehicleInsurance> {
	
	private static final long serialVersionUID = 1L;
	private String vehicleNum;		// 车号
	private String vehicleType;		// 车型
	private String frameNum;		// 车架号
	private String engineNum;		// 发动机号
	private Date regDate;		// 登记日期
	private String insuranceCompany;		// 保险公司
	private String premium;		// 交强险-保费
	private Date closingDate;		// 交强险-截止日期
	private String thirdPartyPremium;		// 商业险-三者/保费
	private String thirdPartyInsuredAmount;		// 商业险-三者/保额
	private String carDamageInsurance;		// 商业险-车损险
	private String riskSpontaneousCombustion;		// 商业险-自燃险
	private String nonDeductible;		// 商业险-不计免赔
	private String otherInsurance;		// 商业险-其他险种
	private Date closingDate1;		// 商业险-截止日期
	private String premium1;		// 道路客运承运人责任险-保费
	private String insuredAmount1;		// 道路客运承运人责任险-保额
	private String closingDate2;		// 道路客运承运人责任险-截止日期
	private String vehicleVesselTax;		// 车船税
	private String totalPremium;		// 保费总合计
	private String compulsoryInsuranceNum;		// 交强险保单号
	private String commercialInsuranceOrderNum;		// 商业险保单号
	private String carrierWarrantyNum;		// 承运人保单号
	private String mark;		// 备注
	private String driverLicense;		// 驾照
	private String queryCode;		// 查询码
	private String pic;		// 保单图片
	private Date beginRegDate;		// 开始 登记日期
	private Date endRegDate;		// 结束 登记日期
	
	private String pic1;
	private String pic2;
	private Date handleDate;
	
	public ZVehicleInsurance() {
		super();
	}

	public ZVehicleInsurance(String id){
		super(id);
	}

	
	@Length(min=0, max=255, message="保单图片长度必须介于 0 和 255 之间")
	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	@Length(min=0, max=255, message="保单图片长度必须介于 0 和 255 之间")
	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
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
	
	@Length(min=0, max=50, message="车型长度必须介于 0 和 50 之间")
	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	@Length(min=0, max=50, message="车架号长度必须介于 0 和 50 之间")
	public String getFrameNum() {
		return frameNum;
	}

	public void setFrameNum(String frameNum) {
		this.frameNum = frameNum;
	}
	
	@Length(min=0, max=50, message="发动机号长度必须介于 0 和 50 之间")
	public String getEngineNum() {
		return engineNum;
	}

	public void setEngineNum(String engineNum) {
		this.engineNum = engineNum;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Length(min=0, max=50, message="保险公司长度必须介于 0 和 50 之间")
	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	
	@Length(min=0, max=50, message="交强险-保费长度必须介于 0 和 50 之间")
	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}
	
	@Length(min=0, max=50, message="商业险-三者/保费长度必须介于 0 和 50 之间")
	public String getThirdPartyPremium() {
		return thirdPartyPremium;
	}

	public void setThirdPartyPremium(String thirdPartyPremium) {
		this.thirdPartyPremium = thirdPartyPremium;
	}
	
	@Length(min=0, max=50, message="商业险-三者/保额长度必须介于 0 和 50 之间")
	public String getThirdPartyInsuredAmount() {
		return thirdPartyInsuredAmount;
	}

	public void setThirdPartyInsuredAmount(String thirdPartyInsuredAmount) {
		this.thirdPartyInsuredAmount = thirdPartyInsuredAmount;
	}
	
	@Length(min=0, max=50, message="商业险-车损险长度必须介于 0 和 50 之间")
	public String getCarDamageInsurance() {
		return carDamageInsurance;
	}

	public void setCarDamageInsurance(String carDamageInsurance) {
		this.carDamageInsurance = carDamageInsurance;
	}
	
	@Length(min=0, max=50, message="商业险-自燃险长度必须介于 0 和 50 之间")
	public String getRiskSpontaneousCombustion() {
		return riskSpontaneousCombustion;
	}

	public void setRiskSpontaneousCombustion(String riskSpontaneousCombustion) {
		this.riskSpontaneousCombustion = riskSpontaneousCombustion;
	}
	
	@Length(min=0, max=50, message="商业险-不计免赔长度必须介于 0 和 50 之间")
	public String getNonDeductible() {
		return nonDeductible;
	}

	public void setNonDeductible(String nonDeductible) {
		this.nonDeductible = nonDeductible;
	}
	
	@Length(min=0, max=50, message="商业险-其他险种长度必须介于 0 和 50 之间")
	public String getOtherInsurance() {
		return otherInsurance;
	}

	public void setOtherInsurance(String otherInsurance) {
		this.otherInsurance = otherInsurance;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getClosingDate1() {
		return closingDate1;
	}

	public void setClosingDate1(Date closingDate1) {
		this.closingDate1 = closingDate1;
	}
	
	@Length(min=0, max=50, message="道路客运承运人责任险-保费长度必须介于 0 和 50 之间")
	public String getPremium1() {
		return premium1;
	}

	public void setPremium1(String premium1) {
		this.premium1 = premium1;
	}
	
	@Length(min=0, max=50, message="道路客运承运人责任险-保额长度必须介于 0 和 50 之间")
	public String getInsuredAmount1() {
		return insuredAmount1;
	}

	public void setInsuredAmount1(String insuredAmount1) {
		this.insuredAmount1 = insuredAmount1;
	}
	
	@Length(min=0, max=50, message="道路客运承运人责任险-截止日期长度必须介于 0 和 50 之间")
	public String getClosingDate2() {
		return closingDate2;
	}

	public void setClosingDate2(String closingDate2) {
		this.closingDate2 = closingDate2;
	}
	
	@Length(min=0, max=50, message="车船税长度必须介于 0 和 50 之间")
	public String getVehicleVesselTax() {
		return vehicleVesselTax;
	}

	public void setVehicleVesselTax(String vehicleVesselTax) {
		this.vehicleVesselTax = vehicleVesselTax;
	}
	
	@Length(min=0, max=50, message="保费总合计长度必须介于 0 和 50 之间")
	public String getTotalPremium() {
		return totalPremium;
	}

	public void setTotalPremium(String totalPremium) {
		this.totalPremium = totalPremium;
	}
	
	@Length(min=0, max=50, message="交强险保单号长度必须介于 0 和 50 之间")
	public String getCompulsoryInsuranceNum() {
		return compulsoryInsuranceNum;
	}

	public void setCompulsoryInsuranceNum(String compulsoryInsuranceNum) {
		this.compulsoryInsuranceNum = compulsoryInsuranceNum;
	}
	
	@Length(min=0, max=50, message="商业险保单号长度必须介于 0 和 50 之间")
	public String getCommercialInsuranceOrderNum() {
		return commercialInsuranceOrderNum;
	}

	public void setCommercialInsuranceOrderNum(String commercialInsuranceOrderNum) {
		this.commercialInsuranceOrderNum = commercialInsuranceOrderNum;
	}
	
	@Length(min=0, max=50, message="承运人保单号长度必须介于 0 和 50 之间")
	public String getCarrierWarrantyNum() {
		return carrierWarrantyNum;
	}

	public void setCarrierWarrantyNum(String carrierWarrantyNum) {
		this.carrierWarrantyNum = carrierWarrantyNum;
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
	
	@Length(min=0, max=255, message="保单图片长度必须介于 0 和 255 之间")
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public Date getBeginRegDate() {
		return beginRegDate;
	}

	public void setBeginRegDate(Date beginRegDate) {
		this.beginRegDate = beginRegDate;
	}
	
	public Date getEndRegDate() {
		return endRegDate;
	}

	public void setEndRegDate(Date endRegDate) {
		this.endRegDate = endRegDate;
	}
		
}