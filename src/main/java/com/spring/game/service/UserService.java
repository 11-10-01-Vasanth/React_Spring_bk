package com.spring.game.service;

import com.spring.game.model.Users;

public interface UserService {

	Object userRegister(Users users);

	boolean userLogin(Users users);

}
