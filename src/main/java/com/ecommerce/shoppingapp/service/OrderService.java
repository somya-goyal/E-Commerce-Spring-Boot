package com.ecommerce.shoppingapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingapp.dao.OrderRepo;
import com.ecommerce.shoppingapp.dto.OrderDto;
import com.ecommerce.shoppingapp.dto.OrderItemDto;
import com.ecommerce.shoppingapp.dto.UserDto;
import com.ecommerce.shoppingapp.exception.EmptyInputException;
import com.ecommerce.shoppingapp.exception.LessQuantityAvailableException;
import com.ecommerce.shoppingapp.models.Order;
import com.ecommerce.shoppingapp.models.OrderItem;
import com.ecommerce.shoppingapp.models.Product;
import com.ecommerce.shoppingapp.models.Seller;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private UserService userService;

	public OrderDto convertToDTO(Order order) {
		return modelMapper.map(order, OrderDto.class);
	}

	public Order convertToEntity(OrderDto orderDto) {
		return modelMapper.map(orderDto, Order.class);
	}

	public OrderItemDto convertToDTO(OrderItem orderItem) {
		return modelMapper.map(orderItem, OrderItemDto.class);
	}

	public OrderItem convertToEntity(OrderItemDto orderItemDto) {
		return modelMapper.map(orderItemDto, OrderItem.class);
	}

	public OrderDto saveOrder(OrderDto orderDto) {
		Order order = new Order();
		if (orderDto.getLocation().isEmpty())
			throw new EmptyInputException("603", "Delievry Location is empty. Please Provide.");
		order.setDeliveryLocation(orderDto.getLocation());
		UserDto userDto = userService.getUser(orderDto.getUserId());
		order.setUser(userService.dtoToUser(userDto));
		order.setDate(LocalDate.now());

		List<OrderItemDto> itemDtoList = orderDto.getOrderItems();

		List<OrderItem> itemList = new ArrayList<OrderItem>();

		for (OrderItemDto itemDto : itemDtoList) {
			Product product = productService.dtoToProduct(productService.getProduct(itemDto.getProductId()));
			Seller seller = sellerService.dtoToSeller(sellerService.searchSellerByName(itemDto.getSellerName()));
			OrderItem item = new OrderItem();
			item.setProduct(product);
			item.setSeller(seller);
			IsQuantitySufficient(product.getQuantity(), itemDto.getQuantity());
			item.setQuantity(itemDto.getQuantity());
			item.setPrice(this.calculatePrice(seller, product) * itemDto.getQuantity());
			itemList.add(item);
		}
		order.setOrderItems(itemList);
		Order o = orderRepo.save(order);
		return convertToDTO(o);
	}

	private float calculatePrice(Seller seller, Product product) {
		float discount = inventoryService.getDiscountPercentage(seller.getId(), product.getId());
		float finalPrice = (product.getMarkedPrice()) - ((product.getMarkedPrice() * discount) / 100f);
		return finalPrice;
	}

	private void IsQuantitySufficient(int AvailableQuantity, int demandedQuantity) {
		if (demandedQuantity > AvailableQuantity)
			throw new LessQuantityAvailableException("602", "Only " + AvailableQuantity + " Pieces Available");
	}
}
