package com.hanghae99.wanted.web.controller;

import com.hanghae99.wanted.service.UserService;
import com.hanghae99.wanted.web.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/selfinfo")
    public ResponseEntity<UserResponse> getMyMemberInfo() {
        return ResponseEntity.ok(userService.getMyInfo());
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getMemberInfo(@PathVariable String email) {
        return ResponseEntity.ok(userService.getMemberInfo(email));
    }
}

