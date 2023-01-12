package com.ecommerce.shoppingapp.dto;

import com.ecommerce.shoppingapp.models.Product;
import com.ecommerce.shoppingapp.models.Seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InventoryDto {

	private int id;

	private float percentage;
	
	private Seller seller;
	
	private Product product;
	
	
}
