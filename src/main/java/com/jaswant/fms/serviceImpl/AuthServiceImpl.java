package com.jaswant.fms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaswant.fms.config.JwtUtil;
import com.jaswant.fms.dto.LoginRequest;
import com.jaswant.fms.dto.LoginResponse;
import com.jaswant.fms.entity.User;
import com.jaswant.fms.repository.UserRepository;
import com.jaswant.fms.service.AuthService;

@Service
public class AuthServiceImpl
        implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public LoginResponse login(
            LoginRequest request) {

        User user =
                userRepository
                        .findByUsername(
                                request.getUsername())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Invalid Username"));

        if (!user.getPassword()
                .equals(
                        request.getPassword())) {

            throw new RuntimeException(
                    "Invalid Password");
        }

        String token =
                jwtUtil.generateToken(
                        user.getUsername());

        return new LoginResponse(token);

    }
}