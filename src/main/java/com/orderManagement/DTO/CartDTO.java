package com.orderManagement.DTO;



import com.orderManagement.entity.Cart;

public class CartDTO {
	
	

	String buyerId;
	
	String productId;
	
	int quantity;
	
	public CartDTO() {}
	


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


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}




	public static CartDTO valueOf(Cart cart) {
		CartDTO cartdto=new CartDTO();
		cartdto.setBuyerId(cart.getCartId().getBuyerId());
		cartdto.setProductId(cart.getCartId().getProductId());
		cartdto.setQuantity(cart.getQuantity());
		return cartdto;
	}
}
