package com.ecommerce.shoppingapp.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

private int orderId;
	
	private int userId;
	private List<OrderItemDto> orderItems;
	
	private String location;
	
	
}
