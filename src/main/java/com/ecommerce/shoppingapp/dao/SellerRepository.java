package com.ecommerce.shoppingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shoppingapp.models.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {

	public Seller findSellerByName(String sellerName);
}
