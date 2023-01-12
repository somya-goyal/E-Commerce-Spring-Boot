package com.ecommerce.shoppingapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingapp.dao.UserRepo;
import com.ecommerce.shoppingapp.dto.UserDto;
import com.ecommerce.shoppingapp.models.User;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepository;
	@Autowired
	private ModelMapper modelMapper;

	public User dtoToUser(UserDto userDto) {
		return modelMapper.map(userDto, User.class);
	}

	public UserDto userToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public UserDto getUser(int userId) {
		User u = userRepository.findById(userId).get();
		return userToDto(u);
	}

	public void removeUser(int userId) {
		userRepository.deleteById(userId);
	}

	public void updateUser(UserDto userDto, int id) {
		User u = userRepository.findById(id).get();
		u.setName(userToDto(u).getName());
		u.setAddress(userToDto(u).getAddress());
		userRepository.save(u);
	}

}