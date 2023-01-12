package com.ecommerce.shoppingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shoppingapp.models.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
