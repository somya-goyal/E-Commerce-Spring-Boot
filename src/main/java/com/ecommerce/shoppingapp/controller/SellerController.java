package com.ecommerce.shoppingapp.controller;

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

import com.ecommerce.shoppingapp.dto.SellerDto;
import com.ecommerce.shoppingapp.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;

		@PostMapping("/")
		public ResponseEntity<?> addSeller(@RequestBody SellerDto sellerDto) {
			SellerDto s=sellerService.addSeller(sellerDto);
			return new ResponseEntity<SellerDto>(s, HttpStatus.CREATED);
		}

		@DeleteMapping("/{sellerId}")
		public ResponseEntity<Void> removeSeller(@PathVariable int sellerId) {
			sellerService.removeSeller(sellerId);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}

		@GetMapping("/{sellerId}")
		public ResponseEntity<?> searchSeller(@PathVariable int sellerId) {
			SellerDto s=sellerService.getSeller(sellerId);
			return new ResponseEntity<SellerDto>(s, HttpStatus.FOUND);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<SellerDto>  updateSeller(@RequestBody SellerDto sellerDto,@PathVariable int id)
		{
			sellerService.updateSeller(sellerDto, id);
			return new ResponseEntity<SellerDto>(sellerDto,HttpStatus.ACCEPTED);
		}
}
