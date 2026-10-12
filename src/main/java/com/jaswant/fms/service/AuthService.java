package com.jaswant.fms.service;

import com.jaswant.fms.dto.LoginRequest;
import com.jaswant.fms.dto.LoginResponse;

public interface AuthService {

    LoginResponse login(
            LoginRequest request);

}