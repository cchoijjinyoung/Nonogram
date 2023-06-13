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
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        authService.join(authRequest);
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
        User user1 = User.builder()
                .username("foo")
                .nickname("bar")
                .password("1234")
                .build();
        userRepository.save(user1);

        AuthRequest authRequest = AuthRequest.builder()
                .username("foo")
                .nickname("bar2")
                .password("1234")
                .build();
        // when
        IllegalStateException e = assertThrows(
                IllegalStateException.class, () -> authService.validateDuplicateUser(authRequest.getUsername()));
        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 ID입니다.");
    }
}
