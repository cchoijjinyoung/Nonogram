package com.logic.nemonemo.controller;

import com.logic.nemonemo.dto.request.AuthRequest;
import com.logic.nemonemo.repository.UserRepository;
import com.logic.nemonemo.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {
    @Autowired
    private AuthController authController;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;


    @BeforeEach
    void clean() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("유저네임이 중복되지 않는 회원의 가입")
    public void shouldSignUpUser() throws Exception {
        //given
        AuthRequest authRequest = new AuthRequest();
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
        AuthRequest authRequest = new AuthRequest();
        //when
        ResponseEntity<String> response = authController.signUp(authRequest);
        //then
        assertThat(response.getStatusCode().value()).isEqualTo(400);
        assertThat(response.getStatusCode().name()).isEqualTo("BAD_REQUEST");
        assertThat(response.getBody()).isEqualTo("회원가입 실패");
    }
}