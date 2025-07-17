package com.BE_13.DevTogether.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"사용자를 찾을 수 없습니다."),
    LOGIN_FAILED(HttpStatus.BAD_REQUEST ,"로그인에 실패하였습니다."),
    ALREADY_REGISTER_USER(HttpStatus.BAD_REQUEST, "이미 사용중인 아이디입니다."),
    WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "잘못된 비밀번호입니다.");

    private final HttpStatus httpStatus;
    private final String message;

}
