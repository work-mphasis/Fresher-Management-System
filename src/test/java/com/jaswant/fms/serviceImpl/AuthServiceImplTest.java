package com.jaswant.fms.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.jaswant.fms.config.JwtUtil;
import com.jaswant.fms.dto.LoginRequest;
import com.jaswant.fms.dto.LoginResponse;
import com.jaswant.fms.entity.User;
import com.jaswant.fms.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private AuthServiceImpl authServiceImpl;

    @Test
    void testLoginSuccess() {

        LoginRequest request = new LoginRequest();
        request.setUsername("admin");
        request.setPassword("admin123");

        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin123");

        when(userRepository.findByUsername("admin"))
                .thenReturn(Optional.of(user));

        when(jwtUtil.generateToken("admin"))
                .thenReturn("jwt-token");

        LoginResponse response =
                authServiceImpl.login(request);

        assertEquals(
                "jwt-token",
                response.getToken());
    }

    @Test
    void testInvalidUsername() {

        LoginRequest request = new LoginRequest();
        request.setUsername("wrong");
        request.setPassword("admin123");

        when(userRepository.findByUsername("wrong"))
                .thenReturn(Optional.empty());

        RuntimeException ex =
                assertThrows(
                        RuntimeException.class,
                        () -> authServiceImpl.login(request));

        assertEquals(
                "Invalid Username",
                ex.getMessage());
    }

    @Test
    void testInvalidPassword() {

        LoginRequest request = new LoginRequest();
        request.setUsername("admin");
        request.setPassword("wrong");

        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin123");

        when(userRepository.findByUsername("admin"))
                .thenReturn(Optional.of(user));

        RuntimeException ex =
                assertThrows(
                        RuntimeException.class,
                        () -> authServiceImpl.login(request));

        assertEquals(
                "Invalid Password",
                ex.getMessage());
    }
}