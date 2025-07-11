package com.BE_13.DevTogether.controller.rest;

import com.BE_13.DevTogether.entity.user.Role;
import com.BE_13.DevTogether.entity.user.User;
import com.BE_13.DevTogether.entity.user.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/user")
@RequiredArgsConstructor
@RestController
public class UserRestController {

    private UserRepository userRepository;

    @Tag(name = "User test", description = "test api 설명입니다.")
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    /**
     * 임시 유저 생성 API 테스트 메서드이다.
     *
     * @param request <String username, String role>
     * @return 생성된 임의의 유저
     * @author chan
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> request) {
        User newUser = User.builder().
                username(request.get("username")).
                role(Role.valueOf(request.get("role"))).
                build();

        User saveUser = userRepository.save(newUser);
        return ResponseEntity.ok(saveUser);
    }
}
