package com.logic.nemonemo.controller;

import com.logic.nemonemo.dto.request.AuthRequest;
import com.logic.nemonemo.repository.UserRepository;
import com.logic.nemonemo.service.AuthService;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthControllerTest {
    @Autowired
    private AuthController authController;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;

    @DisplayName("기본 회원 가입")
    private void saveBasicUser() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setUsername("foo");
        authRequest.setPassword("1234");
        authRequest.setNickname("bar");
        authController.signUp(authRequest);
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
    @DisplayName("유저네임이 중복되지 않는 회원의 가입")
    public void shouldSignUpUser() throws Exception {
        //given
        saveBasicUser();
        AuthRequest authRequest = new AuthRequest();
        authRequest.setUsername("choi");
        authRequest.setPassword("1234");
        //when
        ResponseEntity<String> response = authController.signUp(authRequest);
        //then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getStatusCode().name()).isEqualTo("OK");
        assertThat(response.getBody()).isEqualTo("회원가입 성공");
    }

    @Test
    @DisplayName("유저네임이 중복되는 회원의 가입")
    public void shouldSignUpDuplicatedUsername() throws Exception {
        //given
        saveBasicUser();
        AuthRequest authRequest = new AuthRequest();
        authRequest.setUsername("foo");
        authRequest.setPassword("bar");
        //when
        ResponseEntity<String> response = authController.signUp(authRequest);
        //then
        assertThat(response.getStatusCode().value()).isEqualTo(400);
        assertThat(response.getStatusCode().name()).isEqualTo("BAD_REQUEST");
        assertThat(response.getBody()).isEqualTo("회원가입 실패");
    }
}