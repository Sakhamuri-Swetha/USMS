package com.orderManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


import com.orderManagement.DTO.IsActive;
import com.orderManagement.DTO.IsPrivileged;

@Entity
public class Buyer {
	@Id
	@Column(name = "buyer_id")
	String buyerId;
	@Column(name="buyer_name")
	String name;
	@Column(name="buyer_email")
	String email;
	@Column(name = "buyer_phone")
	String phoneNo;
	@Column(name = "password")
	String password;
	@Column
	@Enumerated(EnumType.STRING)
	IsPrivileged isprivileged;
	@Column(name = "reward_points")
	Integer rewardPoints;
	@Column
	@Enumerated(EnumType.STRING)
	IsActive isactive;
	
	
	public Buyer() {}
		
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public IsPrivileged getIsprivileged() {
		return isprivileged;
	}

	public void setIsprivileged(IsPrivileged isprivileged) {
		this.isprivileged = isprivileged;
	}

	public Integer getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public IsActive getIsActive() {
		return isactive;
	}
	public void setIsActive(IsActive isActive) {
		this.isactive = isActive;
	}

	
	
}
