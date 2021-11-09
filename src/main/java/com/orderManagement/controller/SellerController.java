package com.orderManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orderManagement.DTO.LoginDTO;
import com.orderManagement.DTO.SellerDTO;
import com.orderManagement.exception.InfyUserException;
import com.orderManagement.service.SellerService;

@RestController
@CrossOrigin
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
	@RequestMapping(value="/seller/login",method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity<String>Validate(@Valid @RequestBody LoginDTO login)throws InfyUserException{
			Boolean result=false;
			result=sellerService.login(login);
			if(result) {
			return new ResponseEntity<String>("Login Successful",HttpStatus.OK);
		}
			return new ResponseEntity<String>("Please Try Again",HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value = "/seller/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createBuyer(@Valid @RequestBody SellerDTO sellerDTO) throws InfyUserException{
		String s=sellerService.createSeller(sellerDTO);
		return "Seller registered successfully with sellerId: "+s;
	}
	
	@RequestMapping(value="/sellers/list", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<SellerDTO> getAllSellers(){
		return sellerService.getAllSellers();
	}
	
	@RequestMapping(value = "/seller/{sellerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SellerDTO getSellerProfile(@PathVariable String sellerId){
		return sellerService.getSellerProfile(sellerId);
	}
	
	@DeleteMapping(value="/seller/{sellerId}")
	public String deactivateSeller(@PathVariable String sellerId) {
		try {
			sellerService.inactiveSeller(sellerId);
		} catch (InfyUserException e) {
			// TODO Auto-generated catch block
			return "Error Deactivating User";
		}
		return "User succesfully deactivated";
	}

}
