package com.spring.game.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.game.model.Users;
import com.spring.game.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> userRegister(@RequestBody Users users) throws Exception {
		Object savedEntity = userService.userRegister(users);
		return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
	}
	
	@PostMapping("/login")
	public boolean userLogin(@RequestBody Users users) throws Exception {
		boolean savedEntity = userService.userLogin(users);
		return savedEntity;
	}

}
