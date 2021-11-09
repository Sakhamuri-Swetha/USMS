package com.orderManagement.entity;



import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class Wishlist {
	
	@EmbeddedId
	public WishlistId wishlistId;

	public Wishlist(WishlistId wishlistId) {
		super();
		this.wishlistId = wishlistId;
	}

	public WishlistId getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(WishlistId wishlistId) {
		this.wishlistId = wishlistId;
	}
	
	public Wishlist() {}
	

}
