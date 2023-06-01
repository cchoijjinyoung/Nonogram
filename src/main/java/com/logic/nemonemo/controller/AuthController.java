package com.logic.nemonemo.controller;

import com.logic.nemonemo.dto.request.AuthRequest;
import com.logic.nemonemo.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Log4j2
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(AuthRequest authRequest) {
        boolean avaliable = authService.isUsernameAvaliable(authRequest.getUsername());
        if (avaliable) {
            authService.signUp(authRequest);
            return ResponseEntity.ok("회원가입 성공");
        }
        return ResponseEntity.badRequest().body("회원가입 실패");
    }
}
