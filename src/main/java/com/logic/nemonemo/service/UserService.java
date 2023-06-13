package com.logic.nemonemo.service;

import com.logic.nemonemo.dto.request.UserRequest;
import com.logic.nemonemo.dto.response.UserResponse;
import com.logic.nemonemo.entity.User;
import com.logic.nemonemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse findOne(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        UserResponse userResponse = UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .password(user.getPassword())
                .build();
        return userResponse;
    }

    public UserResponse updateUser(UserRequest userRequest) {
        User user = userRepository.findById(userRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        UserResponse userResponse = UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(userRequest.getNickname())
                .build();
        return userResponse;
    }

    public List<UserResponse> findUserList() {
        return userRepository.findAll().stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .nickname(user.getNickname())
                        .password(user.getPassword())
                        .build())
                .collect(Collectors.toList());
    }
}

