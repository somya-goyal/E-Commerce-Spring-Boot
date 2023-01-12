package com.ecommerce.shoppingapp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

	@Id
	@Column(name = "ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name = "Address",nullable = false)
	private String address;
	
	@Column(name = "Name",nullable = false)
	private String name;
	
	@Column(name="CreatedDate")
	private Date createdDate;
	
	@Column(name="EndDate")
	private Date endDate;
	
}
