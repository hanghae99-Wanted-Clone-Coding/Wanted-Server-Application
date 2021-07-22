package com.hanghae99.wanted.web.controller;

import com.hanghae99.wanted.service.AuthService;
import com.hanghae99.wanted.web.dto.response.TokenResponse;
import com.hanghae99.wanted.web.dto.request.TokenRequest;
import com.hanghae99.wanted.web.dto.request.UserRequest;
import com.hanghae99.wanted.web.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(authService.signup(userRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(authService.login(userRequest));
    }
    // refresh 토큰 삭제
}