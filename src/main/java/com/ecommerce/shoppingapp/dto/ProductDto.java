package com.ecommerce.shoppingapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
	
	private int id;

	private String productName;
	
	private float markedPrice;

	private String category;
	
	private int Quantity;
	
}
