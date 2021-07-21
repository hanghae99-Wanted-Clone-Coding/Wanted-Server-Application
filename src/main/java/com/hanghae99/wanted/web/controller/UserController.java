package com.hanghae99.wanted.web.controller;

import com.hanghae99.wanted.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {
    private final UserService userService;
    /**
     * 카카오 인가 코드 받기
     */
    @GetMapping("/{kakao-auth-code}")
    public String kakaoAuthCode(@PathVariable("kakao-auth-code") String kakaoCode) {
        System.out.println(kakaoCode);
        userService.kakaoLogin(kakaoCode);
        return "Kakao Auth Code: " + kakaoCode;
    }

//    @GetMapping("/user/kakao/callback")
//    public String kakaoLogin(String code) {
//        System.out.println("second mapping" + code);
//        // authorizedCode: 카카오 서버로부터 받은 인가 코드
//        userService.kakaoLogin(code);
//
//        return "redirect:/";
//    }
}

