package com.logic.nemonemo.service;

import com.logic.nemonemo.dto.request.AuthRequest;
import com.logic.nemonemo.entity.User;
import com.logic.nemonemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    public void signUp(AuthRequest authRequest) {
        User user = User.builder()
                .username(authRequest.getUsername())
                .password(authRequest.getPassword())
                .nickname(authRequest.getNickname())
                .build();
        userRepository.save(user);
    }

    /**
     * 유효성 검사
     * 닉네임 중복
     */
    public boolean isUsernameAvaliable(String username) {
        Optional<User> existingUser = userRepository.findByUsername(username);
        return existingUser.isEmpty();
    }
}
