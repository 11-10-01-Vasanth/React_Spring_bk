package com.spring.game.serviceimpl;

import org.springframework.stereotype.Service;

import com.spring.game.model.Admin;
import com.spring.game.repo.AdminRepo;
import com.spring.game.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepo adminRepo;

    @Override
    public Admin addgames(Admin entity) {
        return adminRepo.saveAndFlush(entity);
    }

}
