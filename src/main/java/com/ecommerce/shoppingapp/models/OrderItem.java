package com.ecommerce.shoppingapp.models;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class OrderItem {

	@OneToOne(cascade = CascadeType.ALL)
	private Seller seller;
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;
	private float price;
	private int quantity;
}
