package com.hanghae99.wanted.service;

import com.hanghae99.wanted.util.SecurityUtil;
import com.hanghae99.wanted.web.dto.response.UserResponse;
import com.hanghae99.wanted.web.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponse getMemberInfo(String email) {
        return userRepository.findByEmail(email)
                .map(UserResponse::of)
                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }

    // 현재 SecurityContext 에 있는 유저 정보 가져오기
    @Transactional(readOnly = true)
    public UserResponse getMyInfo() {
        return userRepository.findById(SecurityUtil.getCurrentMemberId().toString())
                .map(UserResponse::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }


}
