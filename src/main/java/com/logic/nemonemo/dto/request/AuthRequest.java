package com.logic.nemonemo.dto.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class AuthRequest {
    private Long id;
    private String nickname;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    // private String email;

    @Builder
    public AuthRequest(Long id, String nickname, String username, String password) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }
}
