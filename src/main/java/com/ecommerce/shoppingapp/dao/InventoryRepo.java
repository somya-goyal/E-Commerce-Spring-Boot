package com.ecommerce.shoppingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shoppingapp.models.Inventory;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

	public Inventory findBySellerIdAndProductId(int sellerId, int productId);
}
