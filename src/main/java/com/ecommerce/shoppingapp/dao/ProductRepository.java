package com.ecommerce.shoppingapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.shoppingapp.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

	@Query("SELECT p FROM Product p WHERE CONCAT(p.name,p.category) LIKE %?1%")
	public List<Product> searchByKeyword(String keyword);
}
