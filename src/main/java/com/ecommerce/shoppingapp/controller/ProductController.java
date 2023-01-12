package com.ecommerce.shoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shoppingapp.dto.ProductDto;
import com.ecommerce.shoppingapp.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/")
	public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
		ProductDto p = productService.addProduct(productDto);
		return new ResponseEntity<ProductDto>(p, HttpStatus.CREATED);
	}

	@GetMapping("/search/{keyword}")
	public List<ProductDto> searchProduct(@PathVariable String keyword) {
		return productService.searchProduct(keyword);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeProduct(@PathVariable int id) {
		productService.removeProduct(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable int id) {
		productService.updateProduct(productDto, id);
		return new ResponseEntity<ProductDto>(productDto, HttpStatus.ACCEPTED);
	}
}
