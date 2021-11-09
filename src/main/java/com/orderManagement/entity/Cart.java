package com.orderManagement.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Cart {
	
	@EmbeddedId
	CartId cartId;
	
	int quantity;
	
	public Cart() {}

	public Cart(CartId cartId, Integer quantity) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
	}

	public CartId getCartId() {
		return cartId;
	}

	public void setCartId(CartId cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	
	
}

