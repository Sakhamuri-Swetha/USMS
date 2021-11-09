package com.orderManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderManagement.entity.Buyer;


public interface BuyerRepository extends JpaRepository<Buyer,String> {
	Buyer findByEmail(String email);
	
}
