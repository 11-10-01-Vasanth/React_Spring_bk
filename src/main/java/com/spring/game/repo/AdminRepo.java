package com.spring.game.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.game.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, UUID>{

}
