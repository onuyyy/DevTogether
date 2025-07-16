package com.BE_13.DevTogether.controller.rest;

import com.BE_13.DevTogether.dto.request.SignIn;
import com.BE_13.DevTogether.entity.user.Role;
import com.BE_13.DevTogether.entity.user.User;
import com.BE_13.DevTogether.entity.user.UserRepository;
import com.BE_13.DevTogether.service.SignInService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/user")
@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserRepository userRepository;
    private final SignInService signInService;
    private final PasswordEncoder passwordEncoder;
    // todo : createUser 할 때 비밀번호 처리

    /**
     * 임시 유저 생성 API 테스트 메서드이다.
     *
     * @param request <String username, String role>
     * @return 생성된 임의의 유저
     * @author chan
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> request) {

        String password = request.get("password");
        String encodedPassword = passwordEncoder.encode(password);
        User newUser = User.builder().
                username(request.get("username")).
                password(encodedPassword).
                role(Role.valueOf(request.get("role"))).
                build();

        User saveUser = userRepository.save(newUser);
        return ResponseEntity.ok(saveUser);
    }

    @Tag(name = "User Login", description = "로그인시 username, password를 받습니다.")
    @PostMapping("/login")
    public ResponseEntity<User> login(@Valid @RequestBody SignIn form) {

        User user = signInService.signIn(form);

        return ResponseEntity.ok(user);
    }
}
