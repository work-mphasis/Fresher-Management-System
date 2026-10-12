package com.jaswant.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jaswant.fms.entity.User;
import com.jaswant.fms.repository.UserRepository;
import com.jaswant.fms.dto.LoginRequest;
import com.jaswant.fms.dto.LoginResponse;
import com.jaswant.fms.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        return authService.login(request);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }
}