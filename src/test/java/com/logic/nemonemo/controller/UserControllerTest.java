package com.logic.nemonemo.controller;

import com.logic.nemonemo.dto.response.UserResponse;
import com.logic.nemonemo.entity.User;
import com.logic.nemonemo.repository.UserRepository;
import com.logic.nemonemo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

    @Autowired
    UserService userService;
    @Autowired
    UserController userController;
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void clean() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("id로 회원조회")
    void shouldFindUserById() {
        User user = User.builder()
                .username("foo")
                .nickname("bar")
                .build();
        userRepository.save(user);
        UserResponse userResponse = userController.getUserById(1L);
        //then
        assertNotNull(userResponse);
        assertEquals("foo", userResponse.getUsername());
        assertEquals("bar", userResponse.getNickname());
    }
}