package com.logic.nemonemo.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private int status;
    private String message;

    @Builder
    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
