package com.ecommerce.shoppingapp.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "MyOrder")
public class Order {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	@OneToOne
	private User user;
	
	@ElementCollection
	private List<OrderItem> orderItems;
	
	@Column(name = "Location")
	private String deliveryLocation;
	
	@Column(name = "Date")
	private LocalDate date;
}
