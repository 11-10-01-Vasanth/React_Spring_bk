package com.spring.game.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.game.model.Users;
import com.spring.game.repo.UserRepo;
import com.spring.game.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public Object userRegister(Users users) {
	    Users existusername = userRepo.findByUsername(users.getUsername());
	    Users existmobile = userRepo.findByUsername(users.getMobile());
	    Users existemail = userRepo.findByUsername(users.getEmail());
	    if (existusername != null) {
	        return "Username already exists";
	    } 
	    if (existmobile != null) {
	        return "Mobile number already exists";
	    } 
	    if (existemail != null) {
	        return "Email already exists";
	    } 
	    else {
	        users.setCreatedAt(new Date(System.currentTimeMillis()));
	        Users user = userRepo.saveAndFlush(users);
	        return user;
	    }
	}

	@Override
	public boolean userLogin(Users users) {
	    Users existingUser = userRepo.findByUsername(users.getUsername());
	    if (existingUser != null && existingUser.getMobile().equals(users.getMobile())) {
	        return true;
	    }
	    return false;
	}



}
