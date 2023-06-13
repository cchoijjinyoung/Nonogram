package com.logic.nemonemo.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {
    private Long id;
    private String username;
    private String nickname;
    private String password;

    @Builder
    public UserResponse(Long id, String nickname, String username, String password) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }
}
