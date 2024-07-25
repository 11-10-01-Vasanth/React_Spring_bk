package com.spring.game.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.game.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/admin")

public class AdminaddgameController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addgames")
    public ResponseEntity<ResponseEntity<String>> addGames(
            @RequestParam("gametitle") String gametitle,
            @RequestParam("gamedescription") String gamedescription,
            @RequestParam("gameprice") Double gameprice,
            @RequestParam("gamediscount") Double gamediscount,
            @RequestParam("gamecategory") String gamecategory,
            @RequestParam("gameimage") MultipartFile gameimage) {
        ResponseEntity<String> savedEntity = adminService.addgames(gametitle, gamedescription, gameprice, gamediscount,
                gamecategory, gameimage);
        return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
    }

    @GetMapping("/getAll/{page}/{size}")
    public ResponseEntity<?> getAllGames(@PathVariable int page, @PathVariable int size) {
        return adminService.getAllGames(page,size);
    }
    

}
