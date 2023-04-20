package com.logic.nemonemo.service;

import com.logic.nemonemo.dto.response.UserResponse;
import com.logic.nemonemo.entity.User;
import com.logic.nemonemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        UserResponse userResponse = new UserResponse();

        // builder 추가해야함.
        userResponse.setId(user.get().getId());
        return userResponse;
    }
}

