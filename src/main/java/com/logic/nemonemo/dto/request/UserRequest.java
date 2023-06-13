package com.logic.nemonemo.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class UserRequest {
    private Long id;
    @NotEmpty
    private String username;
    private String nickname;
    @NotEmpty
    private String password;
    /*
    private String email;
    private String image;
    private int level;
    private UserRole role;
    */
    @Builder
    public UserRequest(Long id, String nickname, String username, String password) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }
}
