package com.jaswant.fms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.jaswant.fms.dto.LoginRequest;
import com.jaswant.fms.dto.LoginResponse;
import com.jaswant.fms.entity.User;
import com.jaswant.fms.repository.UserRepository;
import com.jaswant.fms.service.AuthService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @Mock
    private AuthService authService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthController authController;

    @Test
    void testLogin() {

        LoginRequest request = new LoginRequest();
        LoginResponse response = new LoginResponse("test-token");

        when(authService.login(request)).thenReturn(response);

        LoginResponse result = authController.login(request);

        assertEquals("test-token", result.getToken());
    }

    @Test
    void testGetAllUsers() {

        List<User> users = new ArrayList<>();

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = authController.getAllUsers();

        assertEquals(users, result);
    }
}