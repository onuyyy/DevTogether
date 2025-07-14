package com.BE_13.DevTogether.security;

import com.BE_13.DevTogether.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByUsername(username)
                .map(user -> User.withUsername(user.getUsername())
                        .password(user.getPassword())
                        .roles(String.valueOf(user.getRole().name().replace("ROLE_", "")))
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("{} 사용자를 찾을 수 없습니다." + username));

        log.info("userdetails: {}", userDetails);
        log.info(userDetails.getAuthorities().toString());

        return userDetails;
    }
}
