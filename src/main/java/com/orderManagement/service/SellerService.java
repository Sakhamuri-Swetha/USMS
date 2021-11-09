package com.orderManagement.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderManagement.DTO.LoginDTO;
import com.orderManagement.DTO.SellerDTO;
import com.orderManagement.entity.Seller;
import com.orderManagement.exception.InfyUserException;
import com.orderManagement.repository.SellerRepository;

@Service
@Transactional

public class SellerService {
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SellerRepository sellerRepo;
	
	static int index=101;
	
	
	//Seller Registration
	public String createSeller(SellerDTO sellerdto){
		logger.info("Creation request for Seller",sellerdto);
		String s="S" + index++;
		sellerdto.setSellerId(s);
		Seller seller=sellerdto.createEntity();
		sellerRepo.save(seller);
		return seller.getSellerId();
	}
	
	//Login
	public boolean login(LoginDTO loginDTO) {
		Seller seller = sellerRepo.findByEmail(loginDTO.getEmail());
		if (seller != null && seller.getPassword().equals(loginDTO.getPassword())) {
			return true;
		}
		return false;
	}
	
	//Fetch All Sellers
	public List<SellerDTO> getAllSellers(){
		List<Seller> seller=sellerRepo.findAll();
		List<SellerDTO> s= new ArrayList<>();
		for(Seller se:seller) {
			SellerDTO sellerDTO=SellerDTO.valueOf(se);
			s.add(sellerDTO);
		}
		return s;
	}
	
	//Particular Seller Profile
	public SellerDTO getSellerProfile(String sellerId){
		Seller seller=sellerRepo.findById(sellerId).get();
		SellerDTO sellerdto=SellerDTO.valueOf(seller);
		return sellerdto;
	}
	
	//Inactive Seller
	public void inactiveSeller(String sellerId) throws InfyUserException{
		Optional<Seller> s=sellerRepo.findById(sellerId);
		Seller se=s.orElseThrow(()-> new InfyUserException("Seller_Not_Found"));
		sellerRepo.delete(se);
		}

}
