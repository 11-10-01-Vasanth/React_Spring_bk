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
		if (users == null) {
			return "Invalid user data";
		}

		Users existUsername = userRepo.findByUsername(users.getUsername());
		if (existUsername != null) {
			return "Username already exists";
		}

		Users existMobile = userRepo.findByMobile(users.getMobile());
		if (existMobile != null) {
			return "Mobile number already exists";
		}

		Users existEmail = userRepo.findByEmail(users.getEmail());
		if (existEmail != null) {
			return "Email already exists";
		}

		users.setCreatedAt(new Date(System.currentTimeMillis()));
		Users user = userRepo.saveAndFlush(users);
		return user;
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
