package com.orderManagement.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.orderManagement.entity.Wishlist;
import com.orderManagement.entity.WishlistId;
import com.orderManagement.repository.WishlistRepository;

@Service
@Transactional
public class WishlistService {

	@Autowired
	WishlistRepository wishlistRepo;
	
	public String addProductToWishlist(String buyerId,String productId){
		String s="Added to Wishlist successfully";
		Wishlist w=new Wishlist();
		w.setWishlistId(new WishlistId(buyerId,productId));
		wishlistRepo.save(w);
		return s;
	}
	
//	public List<WishlistDTO> getWishlist(WishlistId buyerId){
//		List<Wishlist> op=(List<Wishlist>) wishlistRepo.findById(buyerId).get();
//		List<WishlistDTO> wi=new ArrayList<>();
//		op.forEach(m->{
//			WishlistDTO w=WishlistDTO.valueOf(m);
//			wi.add(w);
//		});
//		return wi;
//	}
	
//	public void removeProductFromWishlist(WishlistId w) throws InfyUserException {
//		wishlistRepo
//	}
	
	
}
