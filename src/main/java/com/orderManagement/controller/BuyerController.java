package com.orderManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.orderManagement.DTO.BuyerDTO;
import com.orderManagement.DTO.LoginDTO;
import com.orderManagement.exception.InfyUserException;
import com.orderManagement.service.BuyerService;

@RestController
@CrossOrigin
public class BuyerController {
	
	@Autowired
	BuyerService buyerService;
	
	@Autowired
	Environment environment;
	
	@RequestMapping(value="buyer/login",method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity<Boolean>Validate(@Valid @RequestBody LoginDTO login)throws InfyUserException{
			Boolean result=false;
			result=buyerService.login(login);
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
	
	
	@RequestMapping(value = "/buyer/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createBuyer(@Valid @RequestBody BuyerDTO buyerDTO) throws InfyUserException{
		try {
		String s=buyerService.createBuyer(buyerDTO);
		return new ResponseEntity<>("Buyer Registered Successfully with Id: "+s,HttpStatus.OK);
	}
		catch(Exception e) {
			return new ResponseEntity<>(environment.getProperty(e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
		
	@RequestMapping(value="/buyers/list", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<BuyerDTO> getAllBuyers(){
		return buyerService.getAllBuyers();
	}
	
	@RequestMapping(value = "/buyer/{buyerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BuyerDTO> getBuyerProfile(@PathVariable String buyerId) throws InfyUserException{
			BuyerDTO b= buyerService.getBuyerProfile(buyerId);
			return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/buyer/{buyerId}")
	public String deactivateSeller(@PathVariable String buyerId) {
		try {
			buyerService.inactiveBuyer(buyerId);
		} catch (InfyUserException e) {
			// TODO Auto-generated catch block
			return "Error Deactivating User";
		}
		return "User succesfully deactivated";
	}
	
	@GetMapping(value = "/buyer/updateRewardPoints/{buyerId}/{rewardPoints}")
	public ResponseEntity<String> updateRewardPoints(@PathVariable String buyerId, @PathVariable Integer rewardPoints)
	{
		try {
			String msg = buyerService.updateRewardPoints(buyerId, rewardPoints);
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
		}
	}
	}
	
	
	

