package com.orderManagement.DTO;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.orderManagement.entity.Seller;


public class SellerDTO {
	@Column(unique=true)
	String sellerId;
	@NotNull(message = "{seller.name.absent}")
    @Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message="{seller.name.invalid}")
	String name;
	@Email(message = "{seller.email.invalid}")
    @NotNull(message = "{seller.email.absent}")
	String email;
	@Pattern(regexp="^[6-9]{1}[0-9]{9}$", message="{seller.phone.invalid}")
	
	String phone;
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$#^!%*&])[A-Za-z\\d@$#^!%*&]{7,20}$", 
			message="{seller.password.invalid}")
	String password;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public void setIsactive(IsActive isActive) {
		this.isactive = isActive;
	}
	public static SellerDTO valueOf(Seller seller) {
		SellerDTO sellerDTO = new SellerDTO();
		sellerDTO.setSellerId(seller.getSellerId());
		sellerDTO.setEmail(seller.getEmail());
		sellerDTO.setName(seller.getName());
		sellerDTO.setPassword(seller.getPassword());
		sellerDTO.setPhone(seller.getPhoneNo());
		sellerDTO.setIsactive(seller.getIsactive());
		return sellerDTO;
	}
	
	//Converts DTO into Entity
	public Seller createEntity() {
		Seller seller=new Seller();
		seller.setSellerId(this.sellerId);
		seller.setEmail(this.email);
		seller.setName(this.name);
		seller.setPassword(this.password);
		seller.setPhoneNo(this.phone);
		seller.setIsactive(IsActive.True);
		return seller;

}
}
