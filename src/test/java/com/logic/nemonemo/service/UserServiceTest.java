package com.logic.nemonemo.service;

import com.logic.nemonemo.dto.response.UserResponse;
import com.logic.nemonemo.entity.User;
import com.logic.nemonemo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    void ID로_회원_조회() {
        //given
        User user = User.builder()
                .username("foo")
                .nickname("bar")
                .build();
        userRepository.save(user);
        //when
        UserResponse userResponse = userService.findOne(user.getId());
        //then
        assertNotNull(userResponse);
        assertEquals("foo", userResponse.getUsername());
        assertEquals("bar", userResponse.getNickname());
    }

    @Test
    @DisplayName("회원 목록 조회")
    void 회원_목록_조회() throws Exception {
        //given
        User user1 = User.builder()
                .username("foo1")
                .nickname("bar")
                .password("1234")
                .build();
        userRepository.save(user1);

        User user2 = User.builder()
                .username("foo2")
                .nickname("bar")
                .password("1234")
                .build();
        userRepository.save(user2);
        //when
        List<UserResponse> users = userService.findUserList();
        //then
        assertThat(users.size()).isEqualTo(2L);
    }
}