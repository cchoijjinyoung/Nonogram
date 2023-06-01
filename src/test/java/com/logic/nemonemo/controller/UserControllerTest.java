package com.logic.nemonemo.controller;

import com.logic.nemonemo.dto.request.UserRequest;
import com.logic.nemonemo.dto.response.UserResponse;
import com.logic.nemonemo.repository.UserRepository;
import com.logic.nemonemo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
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

    @Before
    @DisplayName("테스트를 위한 기본회원 가입")
    public void BasicUserSignUp() {
        UserRequest userRequest = new UserRequest();
        userRequest.setId(1L);
        userRequest.setNickname("foo");
        userRequest.setPassword("bar");
        userController.signUp(userRequest);
    }

    @Test
    @DisplayName("회원조회")
    public void shouldFindUserById() throws Exception {
        UserResponse userResponse = userController.getUserById(1L);
        //then
        assertThat(userResponse.getNickname()).isEqualTo("foo");
        assertThat(userResponse.getPassword()).isEqualTo("bar");
    }

    @Test
    @DisplayName("닉네임이 중복되지 않는 회원의 가입")
    public void shouldSignUpUser() throws Exception {
        //given
        UserRequest userRequest = new UserRequest();
        userRequest.setNickname("choi");
        userRequest.setPassword("1234");
        //when
        ResponseEntity<String> response = userController.signUp(userRequest);
        //then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getStatusCode().name()).isEqualTo("OK");
        assertThat(response.getBody()).isEqualTo("회원가입 성공");
    }

    @Test
    @DisplayName("닉네임이 중복되는 회원의 가입")
    public void shouldSignUpUserNotAvaliable() throws Exception {
        //given
        UserRequest userRequest = new UserRequest();
        userRequest.setNickname("foo");
        userRequest.setPassword("bar");
        //when
        ResponseEntity<String> response = userController.signUp(userRequest);
        //then
        assertThat(response.getStatusCode().value()).isEqualTo(400);
        assertThat(response.getStatusCode().name()).isEqualTo("BAD_REQUEST");
        assertThat(response.getBody()).isEqualTo("회원가입 실패");
    }
}