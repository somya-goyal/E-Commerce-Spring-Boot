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

import com.ecommerce.shoppingapp.dto.InventoryDto;
import com.ecommerce.shoppingapp.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/")
	public ResponseEntity<InventoryDto> saveInventory(@RequestBody InventoryDto inventoryDto) {
		InventoryDto i = inventoryService.save(inventoryDto);
		return new ResponseEntity<InventoryDto>(i, HttpStatus.CREATED);
	}

	@PutMapping("/changeDiscount/{id}")
	public ResponseEntity<Void> changeDiscount(@PathVariable int id) {
		inventoryService.change(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<InventoryDto> getInventory(@PathVariable int id) {
		InventoryDto i = inventoryService.get(id);
		return new ResponseEntity<InventoryDto>(i, HttpStatus.FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeInventory(@PathVariable int id) {
		inventoryService.remove(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
