package com.logic.nemonemo.service;

import com.logic.nemonemo.dto.request.AuthRequest;
import com.logic.nemonemo.entity.User;
import com.logic.nemonemo.repository.UserRepository;
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

    @BeforeEach
    void clean() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("회원 가입")
    void 회원가입() throws Exception {
        //given
        AuthRequest authRequest = AuthRequest.builder()
                .username("foo")
                .nickname("bar")
                .password("1234")
                .build();
        //when
        authService.signUp(authRequest);
        //then
        User user = userRepository.findByUsername(authRequest.getUsername()).get();
        assertThat(user.getUsername()).isEqualTo("foo");
        assertThat(user.getNickname()).isEqualTo("bar");
        assertThat(user.getPassword()).isEqualTo("1234");
    }

    @Test
    @DisplayName("닉네임 중복 검사")
    public void 닉네임_중복_검사() throws Exception {
        // given
        User user = User.builder()
                .id(1L)
                .username("foo")
                .nickname("bar")
                .password("1234")
                .build();
        userRepository.save(user);
        // when
        boolean answer = authService.isUsernameAvaliable("foo");
        //then
        assertThat(answer).isEqualTo(false);
    }
}
