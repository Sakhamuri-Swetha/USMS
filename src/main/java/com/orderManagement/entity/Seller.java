package com.orderManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.orderManagement.DTO.IsActive;

@Entity
public class Seller {
	@Id
	@Column(name = "seller_id")
	String sellerId;
	@Column(name="seller_name")
	String name;
	@Column(name="seller_email")
	String email;
	@Column(name = "seller_phone")
	String phoneNo;
	@Column(name = "password")
	String password;
	@Column
	@Enumerated(EnumType.STRING)
	IsActive isactive;
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
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
	public IsActive getIsactive() {
		return isactive;
	}
	public void setIsactive(IsActive isactive) {
		this.isactive = isactive;
	}
	
	

}
