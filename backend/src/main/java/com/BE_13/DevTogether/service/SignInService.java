package com.BE_13.DevTogether.service;

import com.BE_13.DevTogether.dto.request.SignIn;
import com.BE_13.DevTogether.entity.user.User;
import com.BE_13.DevTogether.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignInService {

    private final UserRepository userRepository;

    public User signIn(SignIn signIn) {

        User user = userRepository.findByUsername(signIn.username())
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        if (BCrypt.checkpw(signIn.password(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 잘못되었습니다.");
        }

        return user;

    }

}
