package com.logic.nemonemo.controller;

import com.logic.nemonemo.dto.response.UserResponse;
import com.logic.nemonemo.entity.User;
import com.logic.nemonemo.repository.UserRepository;
import com.logic.nemonemo.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    UserService userService;
    @Autowired
    UserController userController;
    @Autowired
    UserRepository userRepository;

    @DisplayName("테스트를 위한 기본회원 저장")
    private void saveBasicUser() {
        userRepository.save(User.builder()
                .username("foo")
                .nickname("bar")
                .password("1234")
                .build());
    }
    @BeforeEach
    void cleanUp() {
        userRepository.deleteAll();
    }

    @AfterEach
    void clean() {
        userRepository.deleteAll();
    }
    @Test
    @DisplayName("id로 회원조회")
    public void shouldFindUserById() throws Exception {
        saveBasicUser();
        UserResponse userResponse = userController.getUserById(1L);
        //then
        assertThat(userResponse.getUsername()).isEqualTo("foo");
        assertThat(userResponse.getPassword()).isEqualTo("1234");
    }
}