package com.orderManagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderManagement.DTO.CartDTO;
import com.orderManagement.entity.Cart;
import com.orderManagement.entity.CartId;
import com.orderManagement.repository.CartRepository;

@Service
@Transactional

public class CartService {

	@Autowired
	CartRepository cartRepo;
	
	public String addProductToCart(String buyerId,String productId,Integer quantity) {
		String s="Added to Cart successfully";
		Cart cart=new Cart();
		cart.setCartId(new CartId(buyerId,productId));
		cart.setQuantity(quantity);
		cartRepo.save(cart);
		return s;
	}
	
	public List<CartDTO> getCart(String buyerId){
		List<Cart> c= (List<Cart>) cartRepo.findByCartIdBuyerId(buyerId);
		List<CartDTO> me=new ArrayList<>();
		c.forEach(m->{
			CartDTO cd=new CartDTO();
			cd.setBuyerId(m.getCartId().getBuyerId());
			cd.setProductId(m.getCartId().getProductId());
			cd.setQuantity(m.getQuantity());
			me.add(cd);
		});
		return me;
	}
	
	
	public String removeProductFromCart(String buyerId,String productId){
		Cart cart=cartRepo.findByCartIdBuyerIdAndCartIdProductId(buyerId,productId);
		cartRepo.delete(cart);
		return "Removed from Cart Successfully";
	}
}
