package com.BE_13.DevTogether.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 기본 서버를 반환하는 컨트롤러(Controller) 클래스.
 *
 * @author chan
 */
@Controller
public class DevTogetherController {

    @GetMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to DevTogether!!!!!!!!!";
    }

}
