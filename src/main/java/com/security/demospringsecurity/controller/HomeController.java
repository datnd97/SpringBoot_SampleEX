package com.security.demospringsecurity.controller;

import com.security.demospringsecurity.model.Home;
import com.security.demospringsecurity.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping
    public ResponseEntity<?> listHome() {
        List<Home> homes = (List<Home>) homeService.findAll();
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getHome(@PathVariable Long id) {
        Optional<Home> home = homeService.findById(id);
        return new ResponseEntity<>(home,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createHome(@Valid @RequestBody Home home) {

        homeService.save(home);
        return new ResponseEntity<>(home,HttpStatus.CREATED);
    }

}
