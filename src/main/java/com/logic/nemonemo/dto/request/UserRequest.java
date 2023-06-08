package com.logic.nemonemo.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class UserRequest {
    private Long id;
    private String nickname;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    /*
    private String email;
    private String image;
    private int level;
    private UserRole role;
    */
    public UserRequest(Long id, String nickname, String username, String password) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }
}
