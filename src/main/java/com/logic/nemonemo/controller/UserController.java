package com.logic.nemonemo.controller;

import com.logic.nemonemo.dto.request.UserRequest;
import com.logic.nemonemo.dto.response.UserResponse;
import com.logic.nemonemo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Log4j2
public class UserController {
    private final UserService userService;

    @PostMapping("/auth/signup")
    public ResponseEntity<String> signUp(UserRequest userRequest) {
        boolean avaliable = userService.isNicknameAvaliable(userRequest.getNickname());
        if (avaliable) {
            userService.signUp(userRequest);
            return ResponseEntity.ok("회원가입 성공");
        }
        return ResponseEntity.badRequest().body("회원가입 실패");
    }
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}
