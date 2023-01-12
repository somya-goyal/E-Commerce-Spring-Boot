package com.ecommerce.shoppingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shoppingapp.dto.OrderDto;
import com.ecommerce.shoppingapp.service.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/save")
	public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto orderDto) {
		OrderDto o = orderService.saveOrder(orderDto);
		return new ResponseEntity<OrderDto>(o, HttpStatus.CREATED);
	}

}
