package com.logic.nemonemo.service;

import com.logic.nemonemo.dto.response.UserResponse;
import com.logic.nemonemo.entity.User;
import com.logic.nemonemo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @BeforeEach
    void clean() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("id로 회원 조회")
    void shouldFindUserById() {
        //given
        User user = User.builder()
                .username("foo")
                .nickname("bar")
                .build();
        userRepository.save(user);
        //when
        UserResponse userResponse = userService.getUserById(1L);
        //then
        assertNotNull(userResponse);
        assertEquals("foo", userResponse.getUsername());
        assertEquals("bar", userResponse.getNickname());
    }
}