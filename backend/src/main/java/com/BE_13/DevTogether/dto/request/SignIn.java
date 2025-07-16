package com.BE_13.DevTogether.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SignIn(
        @NotBlank(message = "아이디는 필수입니다.")
        String username,

        @NotBlank(message = "비밀번호는 필수입니다.")
        String password
) {
}

