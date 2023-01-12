package com.ecommerce.shoppingapp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Seller {
	
	@Id
	@Column(name = "ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Name",nullable = false)
	private String name;
	
	@Column(name = "Location",nullable = false)
	private String location;
	
	@OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Inventory> discounts;
	
}
