package com.orderManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderManagement.DTO.CartDTO;
import com.orderManagement.entity.CartId;
import com.orderManagement.service.CartService;

@RestController
@CrossOrigin
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping(value="/cart/add/{quantity}")
	public String addProductToCart(@RequestBody CartId c,@PathVariable Integer quantity) {
		String s= cartService.addProductToCart(c.getBuyerId(),c.getProductId(),quantity);
		return s;
	}
	
	
	@DeleteMapping(value="/cart/remove/{buyerId}/{productId}")
	public String removeProductFromCart(@PathVariable String buyerId,@PathVariable String productId) {
			String s=cartService.removeProductFromCart(buyerId,productId);
			return s;
		}
	
	@GetMapping(value="/cart/get/{buyerId}")
	public List<CartDTO> getCart(@PathVariable String buyerId) {
		List<CartDTO> c=cartService.getCart(buyerId);
		return c;
	}
		
}
