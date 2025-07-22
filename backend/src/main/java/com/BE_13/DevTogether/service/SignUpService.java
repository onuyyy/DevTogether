package com.BE_13.DevTogether.service;

import com.BE_13.DevTogether.dto.request.SignUpRequest;
import com.BE_13.DevTogether.entity.user.Role;
import com.BE_13.DevTogether.entity.user.User;
import com.BE_13.DevTogether.entity.user.UserRepository;
import com.BE_13.DevTogether.exception.ErrorCode;
import com.BE_13.DevTogether.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signUp(SignUpRequest signUpRequest) {

        userRepository.findByUsername(signUpRequest.username()).
                ifPresent(u -> new UserException(ErrorCode.ALREADY_REGISTER_USER));

        String encodedPassword = passwordEncoder.encode(signUpRequest.password());
        User newUser = User.builder().
                username(signUpRequest.username()).
                password(encodedPassword).
                role(Role.USER). // # todo : 현재는 USER밖에 없어서 추후 관리자 기능 개발 시 적용
                build();

        return userRepository.save(newUser);
    }
}
