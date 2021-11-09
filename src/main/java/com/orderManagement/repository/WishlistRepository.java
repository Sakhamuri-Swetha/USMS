package com.orderManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderManagement.entity.Wishlist;
import com.orderManagement.entity.WishlistId;

public interface WishlistRepository extends JpaRepository<Wishlist, WishlistId>{
	

}
