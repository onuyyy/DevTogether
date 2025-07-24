package com.BE_13.DevTogether.service;

import com.BE_13.DevTogether.dto.request.SignInRequest;
import com.BE_13.DevTogether.dto.response.SignInResponse;
import com.BE_13.DevTogether.entity.user.User;
import com.BE_13.DevTogether.entity.user.UserRepository;
import com.BE_13.DevTogether.exception.ErrorCode;
import com.BE_13.DevTogether.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SignInResponse signIn(SignInRequest signInRequest) {

        User user = userRepository.findByUsername(signInRequest.username())
                .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(signInRequest.password(), user.getPassword())) {
            throw new UserException(ErrorCode.WRONG_PASSWORD);
        }

        return SignInResponse.from(user);
    }

    // todo : 로그인 실패 시 카운트 정보 저장해서 보안 정책 추가
}
