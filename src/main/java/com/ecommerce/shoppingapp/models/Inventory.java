package com.ecommerce.shoppingapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Inventory {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Percentage")
	private float percentage;
	
	@ManyToOne
	@JoinColumn(name = "Seller_Id")
	@JsonManagedReference
	private Seller seller;
	
	@ManyToOne
	@JoinColumn(name = "Product_Id")
	@JsonManagedReference
	private Product product;
	
	
	
	
	
	
}
