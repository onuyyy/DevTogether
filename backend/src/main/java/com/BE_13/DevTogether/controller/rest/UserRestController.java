package com.BE_13.DevTogether.controller.rest;

import com.BE_13.DevTogether.dto.request.SignIn;
import com.BE_13.DevTogether.dto.request.SignUp;
import com.BE_13.DevTogether.entity.user.User;
import com.BE_13.DevTogether.service.SignInService;
import com.BE_13.DevTogether.service.SignUpService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final SignInService signInService;
    private final SignUpService signUpService;

    /**
     * 유저 생성 API
     *
     * @param signUp <String username, String role>
     * @return 생성된 임의의 유저
     * @author chan
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody SignUp signUp) {

        User user = signUpService.signUp(signUp);

        return ResponseEntity.ok(user);
    }

    /**
     * 로그인 API
     * @param signIn
     * @return
     */
    @Tag(name = "User Login", description = "로그인시 username, password를 받습니다.")
    @PostMapping("/login")
    public ResponseEntity<User> login(@Valid @RequestBody SignIn signIn) {

        // todo : 현재는 세션, 토큰, 쿠키 사용을 하지 않음 토큰 도입 예정
        User user = signInService.signIn(signIn);

        return ResponseEntity.ok(user);
    }
}
