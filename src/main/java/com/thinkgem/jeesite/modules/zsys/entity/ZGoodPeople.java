/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zsys.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 好人好事Entity
 * @author 好人好事
 * @version 2018-01-25
 */
public class ZGoodPeople extends DataEntity<ZGoodPeople> {
	
	private static final long serialVersionUID = 1L;
	private Date regDate;		// 登记时间
	private String vehicleNum;		// 车号
	private String name;		// 姓名
	private String type;		// 类别
	private String rideTime;		// 乘车时间
	private String boradingLocation;		// 上车地点
	private String dropOffPoint;		// 下车地点
	private String receiptor;		// 领取人
	private String contactPhone;		// 联系电话
	
	public ZGoodPeople() {
		super();
	}

	public ZGoodPeople(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Length(min=0, max=50, message="车号长度必须介于 0 和 50 之间")
	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	
	@Length(min=0, max=50, message="姓名长度必须介于 0 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=50, message="类别长度必须介于 0 和 50 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=50, message="乘车时间长度必须介于 0 和 50 之间")
	public String getRideTime() {
		return rideTime;
	}

	public void setRideTime(String rideTime) {
		this.rideTime = rideTime;
	}
	
	@Length(min=0, max=50, message="上车地点长度必须介于 0 和 50 之间")
	public String getBoradingLocation() {
		return boradingLocation;
	}

	public void setBoradingLocation(String boradingLocation) {
		this.boradingLocation = boradingLocation;
	}
	
	@Length(min=0, max=50, message="下车地点长度必须介于 0 和 50 之间")
	public String getDropOffPoint() {
		return dropOffPoint;
	}

	public void setDropOffPoint(String dropOffPoint) {
		this.dropOffPoint = dropOffPoint;
	}
	
	@Length(min=0, max=50, message="领取人长度必须介于 0 和 50 之间")
	public String getReceiptor() {
		return receiptor;
	}

	public void setReceiptor(String receiptor) {
		this.receiptor = receiptor;
	}
	
	@Length(min=0, max=50, message="联系电话长度必须介于 0 和 50 之间")
	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
}