package com.spring.game.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


public interface AdminService {

    ResponseEntity<String> addgames(String gametitle, String gamedescription, Double gameprice, Double gamediscount, String gamecategory, MultipartFile gameimage);

    ResponseEntity<?> getAllGames(int page, int size);

}
