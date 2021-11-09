package com.orderManagement.DTO;

import javax.persistence.EmbeddedId;

import com.orderManagement.entity.Wishlist;
import com.orderManagement.entity.WishlistId;

public class WishlistDTO {

	@EmbeddedId
	public WishlistId wishlistId;

	public WishlistId getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(WishlistId wishlistId) {
		this.wishlistId = wishlistId;
	}

	@Override
	public String toString() {
		return "WishlistDTO [wishlistId=" + wishlistId + "]";
	}

	public WishlistDTO(WishlistId wishlistId) {
		super();
		this.wishlistId = wishlistId;
	}

	public WishlistDTO() {
	}
	
	
	public static WishlistDTO valueOf(Wishlist wishlist) {
		WishlistDTO w=new WishlistDTO();
		w.setWishlistId(wishlist.getWishlistId());
		return w;
	}
	
	
}
