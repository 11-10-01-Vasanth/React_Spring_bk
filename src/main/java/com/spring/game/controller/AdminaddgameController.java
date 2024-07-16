package com.spring.game.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.game.model.Admin;
import com.spring.game.service.AdminService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/admin")

public class AdminaddgameController {

    private AdminService adminService;

    @PostMapping("/addgames")
    public ResponseEntity<?> addgames(@RequestBody Admin entity) {
        // TODO: process POST request
        Admin savedEntity = adminService.addgames(entity);
        return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
    }

}
