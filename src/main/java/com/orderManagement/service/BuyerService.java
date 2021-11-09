package com.orderManagement.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderManagement.exception.InfyUserException;
import com.orderManagement.DTO.BuyerDTO;
import com.orderManagement.DTO.LoginDTO;
import com.orderManagement.entity.Buyer;
import com.orderManagement.repository.BuyerRepository;

@Service
@Transactional
public class BuyerService {
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BuyerRepository buyerRepo;
	
	static int index=101;
	
	//Buyer Registration
	public String createBuyer(BuyerDTO buyerdto) throws InfyUserException{
		logger.info("Creation request for buyer",buyerdto);
		String s="B" + index++;
		buyerdto.setBuyerId(s);
		Buyer buyer=buyerdto.createEntity();
		buyerRepo.save(buyer);
		return buyer.getBuyerId();
	}
	
	//Buyer Login
	public boolean login(LoginDTO loginDTO) throws InfyUserException{
		Buyer buyer = buyerRepo.findByEmail(loginDTO.getEmail());
		if (buyer != null && buyer.getPassword().equals(loginDTO.getPassword())) {
			return true;
		}
		return false;
	}
		
	//Fetch All Buyers
	public List<BuyerDTO> getAllBuyers(){
		List<Buyer> buyer=buyerRepo.findAll();
		List<BuyerDTO> b= new ArrayList<>();
		for(Buyer se:buyer) {
			BuyerDTO buyerDTO=BuyerDTO.valueOf(se);
			b.add(buyerDTO);
		}
		return b;
	}
	
	//Particular Buyer Profile
	public BuyerDTO getBuyerProfile(String buyerId){
		Buyer buyer=buyerRepo.findById(buyerId).get();
		BuyerDTO buyerdto=BuyerDTO.valueOf(buyer);
		return buyerdto;
	}
	
	//Deleting Buyer
	public void inactiveBuyer(String buyerId) throws InfyUserException{
		Optional<Buyer> s=buyerRepo.findById(buyerId);
		Buyer b=s.orElseThrow(()-> new InfyUserException("Buyer_Not_Found"));
		buyerRepo.delete(b);
	}
	
	public String updateRewardPoints(String buyerId,Integer points) throws InfyUserException{
		
		Buyer buyer = buyerRepo.findById(buyerId).get();
		
		if(buyer==null)
			throw new InfyUserException("Buyer not found");
		
		buyer.setRewardPoints(points);
		
		buyerRepo.save(buyer);
		
		return "Reward Points Updated for buyer Id : "+ buyer.getBuyerId();
	}

}
