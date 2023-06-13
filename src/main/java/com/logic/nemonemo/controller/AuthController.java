package com.logic.nemonemo.controller;

import com.logic.nemonemo.dto.request.AuthRequest;
import com.logic.nemonemo.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public void signup(AuthRequest authRequest) {
        authService.join(authRequest);
    }
}
