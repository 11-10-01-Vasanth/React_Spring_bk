package com.spring.game.serviceimpl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.game.model.Admin;
import com.spring.game.repo.AdminRepo;
import com.spring.game.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ResponseEntity<String> addgames(String gametitle, String gamedescription, Double gameprice, Double gamediscount, String gamecategory,
                                           MultipartFile gameimage) {
        if (gameimage.isEmpty()) {
            return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
        }

        try {
            byte[] bytes = gameimage.getBytes();
            UUID uuid = UUID.randomUUID();
            String uploadsLocation = "/home/kernelogy/Vasanth/React_Spring_bk/src/main/resources/resources/uploads/";
            String imageUrl = uuid + "_" + gameimage.getOriginalFilename();
            String fileLocation = uploadsLocation + imageUrl;
            Path path = Paths.get(fileLocation);

            // Ensure the directory exists
            if (!Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }

            Files.write(path, bytes);

            Admin game = new Admin();
            game.setGametitle(gametitle);
            game.setGamedescription(gamedescription);
            game.setGameprice(gameprice);
            game.setGamediscount(gamediscount);
            game.setGamecategory(gamecategory);
            game.setGameimage(imageUrl);
            game.setCreatedAt(new Date(System.currentTimeMillis()));

            adminRepo.save(game);

            return ResponseEntity.ok("Game added successfully with image URL: " + imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Page<Admin>> getAllGames(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Admin> pagedTokens = adminRepo.findAll(pageable);
        return ResponseEntity.ok(pagedTokens);
    }
}
