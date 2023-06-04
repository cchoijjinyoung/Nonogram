package com.logic.nemonemo.service;

import com.logic.nemonemo.dto.response.UserResponse;
import com.logic.nemonemo.entity.User;
import com.logic.nemonemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).get();
        UserResponse userResponse = new UserResponse();
        // builder 추가해야함.
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setPassword(user.getPassword());
        userResponse.setNickname(user.getNickname());
        return userResponse;
    }

    public void updateUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

    }
}

