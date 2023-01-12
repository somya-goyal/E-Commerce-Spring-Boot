package com.ecommerce.shoppingapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingapp.dao.SellerRepository;
import com.ecommerce.shoppingapp.dto.SellerDto;
import com.ecommerce.shoppingapp.exception.EmptyInputException;
import com.ecommerce.shoppingapp.models.Seller;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private ModelMapper modelMapper;

	public SellerDto sellerToDto(Seller seller) {
		return modelMapper.map(seller, SellerDto.class);
	}

	public Seller dtoToSeller(SellerDto sellerDto) {
		return modelMapper.map(sellerDto, Seller.class);
	}

	public SellerDto addSeller(SellerDto sellerDto) {
		ifEmptyNameOrLocation(sellerDto.getName(), sellerDto.getLocation());
		Seller s = sellerRepository.save(dtoToSeller(sellerDto));
		return sellerToDto(s);
	}

	public void removeSeller(int sellerId) {
		sellerRepository.deleteById(sellerId);
	}

	public SellerDto getSeller(int sellerId) {
		Seller seller = sellerRepository.findById(sellerId).get();
		return sellerToDto(seller);
	}

	public SellerDto searchSellerByName(String sellerName) {
		if (sellerName.isEmpty())
			throw new EmptyInputException("601", "Seller Name is empty");
		Seller seller = sellerRepository.findSellerByName(sellerName);
		return sellerToDto(seller);
	}

	public void updateSeller(SellerDto sellerDto, int id) {
		Seller s = sellerRepository.findById(id).get();
		ifEmptyNameOrLocation(sellerDto.getName(), sellerDto.getLocation());
		s.setLocation(sellerDto.getLocation());
		s.setName(sellerDto.getName());
		sellerRepository.save(s);
	}

	private void ifEmptyNameOrLocation(String name, String location) {
		if (name.isEmpty() || location.isEmpty()) {
			throw new EmptyInputException("601", "Either Seller Name or Location is empty");
		}
	}

}
