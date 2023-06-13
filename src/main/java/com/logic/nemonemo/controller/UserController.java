package com.logic.nemonemo.controller;

import com.logic.nemonemo.dto.response.UserResponse;
import com.logic.nemonemo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long id) {
        return userService.findOne(id);
    }

    @PutMapping("/{id}")
    public void modify(@PathVariable("id") Long id) {

        userService.updateUserById(id);
    }
}

