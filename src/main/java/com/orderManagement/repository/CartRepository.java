package com.orderManagement.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderManagement.entity.Cart;
import com.orderManagement.entity.CartId;

public interface CartRepository extends JpaRepository<Cart,CartId>{
	
	List<Cart> findByCartIdBuyerId(String buyerId);
	Cart findByCartIdBuyerIdAndCartIdProductId(String buyerId,String productId);
}

