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

import com.ecommerce.shoppingapp.dto.UserDto;
import com.ecommerce.shoppingapp.models.User;
import com.ecommerce.shoppingapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable int userId) {
		UserDto u = userService.getUser(userId);
		return new ResponseEntity<UserDto>(u, HttpStatus.FOUND);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> removeUser(@PathVariable int userId) {
		userService.removeUser(userId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable int id) {
		userService.updateUser(userDto, id);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.ACCEPTED);
	}
}
