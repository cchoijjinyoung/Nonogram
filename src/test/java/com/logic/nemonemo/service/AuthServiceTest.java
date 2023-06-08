package com.logic.nemonemo.service;

import com.logic.nemonemo.dto.request.AuthRequest;
import com.logic.nemonemo.entity.User;
import com.logic.nemonemo.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthService authService;

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
    @DisplayName("회원 가입")
    public void shouldSignupUser() throws Exception {
        //given
        AuthRequest authRequest = new AuthRequest();
        //when
        authService.signUp(authRequest);
        //then
        User user = userRepository.findByUsername(authRequest.getUsername()).get();
        assertThat(user.getUsername()).isEqualTo("choi");
        assertThat(user.getPassword()).isEqualTo("1234");
        assertThat(user.getNickname()).isEqualTo("jin");
    }

    @Test
    @DisplayName("닉네임 중복 검사")
    public void nicknameDuplicateTest() throws Exception {
        saveBasicUser();
        boolean answer = authService.isUsernameAvaliable("foo");
        //then
        assertThat(answer).isEqualTo(false);
    }
}
