package com.security.demo.service;

import com.security.demo.repositories.UserRepository;
import com.security.demo.services.JwtService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtService jwtService;

    @Test
    @DisplayName("Genera un token correctamente")
    void generateToken() {
        String token = jwtService.generateToken("John", "[ROLE_ADMIN]");

        System.out.println("ESTO ES EL TOKEN: " + token);
    }
}