package com.logic.nemonemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logic.nemonemo.dto.request.AuthRequest;
import com.logic.nemonemo.repository.UserRepository;
import com.logic.nemonemo.service.AuthService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {
    @Autowired
    private AuthController authController;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @AfterEach
    void clean() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("회원가입")
    public void 회원가입() throws Exception {
        //given
        AuthRequest authRequest = AuthRequest.builder()
                .username("foo")
                .nickname("bar")
                .password("1234")
                .build();
        //when
        authController.signup(authRequest);
        //then
        mockMvc.perform(post("/auth/signup")
                        .content(objectMapper.writeValueAsString(authRequest))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}