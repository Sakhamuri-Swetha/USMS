package com.orderManagement.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.orderManagement.entity.WishlistId;
import com.orderManagement.service.WishlistService;

@RestController
@CrossOrigin
public class WishlistController {

	@Autowired
	WishlistService wishService;
	
	@PostMapping(value="/wishlist/add")
	public String addProductToWishlist(@RequestBody WishlistId w) {
		String s= wishService.addProductToWishlist(w.getBuyerId(),w.getProductId());
		return s;
	}
}
	
