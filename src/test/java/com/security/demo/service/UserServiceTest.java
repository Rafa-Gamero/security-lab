package com.security.demo.service;

import com.security.demo.models.User;
import com.security.demo.repositories.UserRepository;
import com.security.demo.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    private User user;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setUsername("Rafa");
        user.setPassword("1234");
        System.out.println("El usuario inicial es: " + user);

        userService.saveUser(user);
    }

//    @AfterEach
//    public void tearDown() {
//        userRepository.delete(user);
//    }

    @Test
    @DisplayName("La encriptación de passwords es correcta")
    public void passwordEncryption() {
        assertTrue(user.getPassword().startsWith("$2a$")); // todas las strings encriptadas con bcrypt usando el algoritmo que estamos usando deberían empezar así
        System.out.println("este es el user final: " + user);
    }
}
