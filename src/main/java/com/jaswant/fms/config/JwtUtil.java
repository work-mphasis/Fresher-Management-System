package com.jaswant.fms.config;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String username) {

        return "TOKEN_" + username;
    }

}