/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 责任经营者变更业务办理查询Entity
 * @author tom
 * @version 2017-12-14
 */
public class ZOperatorBusinessChange extends DataEntity<ZOperatorBusinessChange> {
	
	private static final long serialVersionUID = 1L;
	private String num;		// 编号
	private String oriVehicleNum;		// 原车牌号
	private String newVehicleNum;		// 新车牌号
	private String name;		// 姓名
	private String idCard;		// 身份证号
	private String allowedDriveModel;		// 准驾车型
	private Date initialDate;		// 初领日期
	private String quaCertNum;		// 从业资格证号
	private Date quaCertInitialDate;		// 从业资格证初领日期
	private String phoneNum;		// 电话
	private String address;		// 地址
	private Date boardingTime;		// 上车时间
	private String queryCode;		// 查询号码
	private String step;		// 审批流程
	private Date beginBoardingTime;		// 开始 上车时间
	private Date endBoardingTime;		// 结束 上车时间
	
	public ZOperatorBusinessChange() {
		super();
	}

	public ZOperatorBusinessChange(String id){
		super(id);
	}

	@Length(min=0, max=50, message="编号长度必须介于 0 和 50 之间")
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	@Length(min=0, max=50, message="原车牌号长度必须介于 0 和 50 之间")
	public String getOriVehicleNum() {
		return oriVehicleNum;
	}

	public void setOriVehicleNum(String oriVehicleNum) {
		this.oriVehicleNum = oriVehicleNum;
	}
	
	@Length(min=0, max=50, message="新车牌号长度必须介于 0 和 50 之间")
	public String getNewVehicleNum() {
		return newVehicleNum;
	}

	public void setNewVehicleNum(String newVehicleNum) {
		this.newVehicleNum = newVehicleNum;
	}
	
	@Length(min=0, max=50, message="姓名长度必须介于 0 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=50, message="身份证号长度必须介于 0 和 50 之间")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Length(min=0, max=50, message="准驾车型长度必须介于 0 和 50 之间")
	public String getAllowedDriveModel() {
		return allowedDriveModel;
	}

	public void setAllowedDriveModel(String allowedDriveModel) {
		this.allowedDriveModel = allowedDriveModel;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
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
	
	@Length(min=0, max=50, message="电话长度必须介于 0 和 50 之间")
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	@Length(min=0, max=50, message="地址长度必须介于 0 和 50 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(Date boardingTime) {
		this.boardingTime = boardingTime;
	}
	
	@Length(min=0, max=50, message="查询号码长度必须介于 0 和 50 之间")
	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}
	
	@Length(min=0, max=50, message="审批流程长度必须介于 0 和 50 之间")
	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}
	
	public Date getBeginBoardingTime() {
		return beginBoardingTime;
	}

	public void setBeginBoardingTime(Date beginBoardingTime) {
		this.beginBoardingTime = beginBoardingTime;
	}
	
	public Date getEndBoardingTime() {
		return endBoardingTime;
	}

	public void setEndBoardingTime(Date endBoardingTime) {
		this.endBoardingTime = endBoardingTime;
	}
		
}