package com.spring.game.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.game.model.Users;

public interface UserRepo extends JpaRepository<Users, UUID> {

	Users findByUsername(String username);

    Users findByMobile(String mobile);

    Users findByEmail(String email);

}
