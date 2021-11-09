package com.orderManagement.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class CartId implements Serializable {
	
	String buyerId;
	
	String productId;
	
	public CartId(String buyer_id,String product_id) {
		this.buyerId=buyer_id;
		this.productId=product_id;
	}

	
	public CartId() {}
	
	public String getBuyerId() {
		return buyerId;
	}



	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}



	public String getProductId() {
		return productId;
	}



	public void setProductId(String productId) {
		this.productId = productId;
	}



	@Override
	public int hashCode() {
		return Objects.hash(buyerId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartId other = (CartId) obj;
		return Objects.equals(buyerId, other.buyerId) && Objects.equals(productId, other.productId);
	}
	
	
	
}

