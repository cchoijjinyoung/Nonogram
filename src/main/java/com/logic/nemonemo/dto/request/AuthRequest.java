package com.logic.nemonemo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    private Long id;
    private String nickname;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    // private String email;

}
