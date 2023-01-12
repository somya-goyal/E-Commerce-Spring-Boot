package com.ecommerce.shoppingapp.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class LessQuantityAvailableException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMessage;

}
