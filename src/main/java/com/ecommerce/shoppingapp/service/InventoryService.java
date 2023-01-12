package com.ecommerce.shoppingapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingapp.dao.InventoryRepo;
import com.ecommerce.shoppingapp.dto.InventoryDto;
import com.ecommerce.shoppingapp.models.Inventory;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepo inventoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	public Inventory dtoToInventory(InventoryDto dto) {
		return modelMapper.map(dto, Inventory.class);
	}

	public InventoryDto inventoryToDto(Inventory inventory) {
		return modelMapper.map(inventory, InventoryDto.class);
	}

	public InventoryDto save(InventoryDto inventoryDto) {
		Inventory i=inventoryRepo.save(dtoToInventory(inventoryDto));
		return inventoryToDto(i);
	}

	public void change(int id) {
		float percent = (inventoryRepo.findById(id).get().getPercentage()) + 1f;
		inventoryRepo.findById(id).get().setPercentage(percent);
		inventoryRepo.save(inventoryRepo.findById(id).get());

	}

	public void remove(int id) {
		inventoryRepo.deleteById(id);
	}

	public InventoryDto get(int id) {
		return inventoryToDto(inventoryRepo.findById(id).get());
	}

	public float getDiscountPercentage(int sellerId, int productId) {
		return inventoryRepo.findBySellerIdAndProductId(sellerId, productId).getPercentage();
	}

}
