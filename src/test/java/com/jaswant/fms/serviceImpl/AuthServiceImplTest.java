package com.jaswant.fms.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        LoginRequest request =
                new LoginRequest();

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
}