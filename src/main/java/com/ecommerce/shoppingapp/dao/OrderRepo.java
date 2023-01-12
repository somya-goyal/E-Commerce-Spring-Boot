package com.ecommerce.shoppingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shoppingapp.models.Order;
@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
