package com.ecommerce.shoppingapp.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingapp.dao.ProductRepository;
import com.ecommerce.shoppingapp.dto.ProductDto;
import com.ecommerce.shoppingapp.exception.EmptyInputException;
import com.ecommerce.shoppingapp.models.Product;
import com.google.common.reflect.TypeToken;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ModelMapper modelMapper;

	public Product dtoToProduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		return product;
	}

	public ProductDto productToDto(Product product) {
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		return productDto;
	}

	public List<ProductDto> convertListEntityToDto(List<Product> list) {
		Type listType = new TypeToken<List<ProductDto>>() {

			private static final long serialVersionUID = 1L;
		}.getType();
		List<ProductDto> dtoList = modelMapper.map(list, listType);
		return dtoList;
	}

	public ProductDto addProduct(ProductDto productDto) {
		if (productDto.getProductName().isEmpty() || productDto.getQuantity() == 0
				|| productDto.getCategory().isEmpty())
			throw new EmptyInputException("601", "Product Name field is empty");
		Product prod = productRepository.save(dtoToProduct(productDto));
		return productToDto(prod);
	}

	public List<ProductDto> searchProduct(String keyword) {
		if (keyword != null) {
			List<Product> list = productRepository.searchByKeyword(keyword);
			return convertListEntityToDto(list);
		}
		return convertListEntityToDto(productRepository.findAll());
	}

	public void removeProduct(int id) {
		productRepository.deleteById(id);
	}

	public ProductDto getProduct(int id) {
		Product prod = productRepository.findById(id).get();
		return productToDto(prod);
	}

	public void updateProduct(ProductDto productDto, int id) {
		Product p = productRepository.findById(id).get();
		ProductDto prodDto = productToDto(p);
		p.setName(prodDto.getProductName());
		p.setCategory(prodDto.getCategory());
		p.setMarkedPrice(prodDto.getMarkedPrice());
		productRepository.save(p);
	};

}
