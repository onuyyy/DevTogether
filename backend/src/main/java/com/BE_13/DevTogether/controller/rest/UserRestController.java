package com.BE_13.DevTogether.controller.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
public class UserRestController {

    @Tag(name = "User test", description = "test api 설명입니다.")
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
