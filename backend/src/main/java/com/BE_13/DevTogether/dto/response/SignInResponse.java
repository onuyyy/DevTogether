package com.BE_13.DevTogether.dto.response;

import com.BE_13.DevTogether.entity.user.User;

public record SignInResponse(String username, Long id) {

    public static SignInResponse from(User user) {
        return new SignInResponse(user.getUsername(), user.getId());
    }
}
