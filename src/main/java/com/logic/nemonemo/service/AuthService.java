package com.logic.nemonemo.service;

import com.logic.nemonemo.dto.request.AuthRequest;
import com.logic.nemonemo.entity.User;
import com.logic.nemonemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    public void join(AuthRequest authRequest) {
        validateDuplicateUser(authRequest.getUsername());
        User user = User.builder()
                .username(authRequest.getUsername())
                .nickname(authRequest.getNickname())
                .password(authRequest.getPassword())
                .build();
        userRepository.save(user);
    }

    public void validateDuplicateUser(String username) {
        userRepository.findByUsername(username)
                .ifPresent((u -> {
                    throw new IllegalStateException("이미 존재하는 ID입니다.");
                }));
    }
}
