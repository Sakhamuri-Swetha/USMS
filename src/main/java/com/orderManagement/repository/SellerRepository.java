package com.orderManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderManagement.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller,String> {
	Seller findByEmail(String email);

}
