package com.logic.nemonemo.service;

import com.logic.nemonemo.dto.request.UserRequest;
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
        Optional<User> user = userRepository.findById(id);
        UserResponse userResponse = new UserResponse();
        // builder 추가해야함.
        userResponse.setId(user.get().getId());
        userResponse.setNickname(user.get().getNickname());
        userResponse.setPassword(user.get().getPassword());
        return userResponse;
    }

    public void signUp(UserRequest userRequest) {
        User user = User.builder()
                .nickname(userRequest.getNickname())
                .password(userRequest.getPassword())
                .username(userRequest.getUsername())
                .build();
        userRepository.save(user);
    }

    public boolean isNicknameAvaliable(String nickname) {
        Optional<User> existingUser = userRepository.findByNickname(nickname);
        return existingUser.isEmpty();
    }
}

