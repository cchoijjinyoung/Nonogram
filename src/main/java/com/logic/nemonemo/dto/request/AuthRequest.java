package com.logic.nemonemo.dto.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class AuthRequest {
    @NotEmpty
    private String username;
    private String nickname;
    @NotEmpty
    private String password;

    // private String email;

    @Builder
    public AuthRequest(String nickname, String username, String password) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }
}
