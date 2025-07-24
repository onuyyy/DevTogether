package com.BE_13.DevTogether.controller.rest;

import com.BE_13.DevTogether.dto.request.SignInRequest;
import com.BE_13.DevTogether.dto.request.SignUpRequest;
import com.BE_13.DevTogether.dto.response.SignInResponse;
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
     * @param signUpRequest <String username, String role>
     * @return 생성된 임의의 유저
     * @author chan
     */
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody SignUpRequest signUpRequest) {

        User user = signUpService.signUp(signUpRequest);

        return ResponseEntity.ok("회원가입 완료");
    }

    /**
     * 로그인 API
     * @param signInRequest
     * @return
     */
    @Tag(name = "User Login", description = "로그인시 username, password를 받습니다.")
    @PostMapping("/login")
    public ResponseEntity<SignInResponse> login(@Valid @RequestBody SignInRequest signInRequest) {

        // todo : 현재는 세션, 토큰, 쿠키 사용을 하지 않음 토큰 도입 예정
        return ResponseEntity.ok(signInService.signIn(signInRequest));
    }
}
