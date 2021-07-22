package com.hanghae99.wanted.service;

import com.hanghae99.wanted.jwt.TokenProvider;
import com.hanghae99.wanted.web.dto.response.TokenResponse;
import com.hanghae99.wanted.web.dto.request.UserRequest;
import com.hanghae99.wanted.web.dto.response.UserResponse;
import com.hanghae99.wanted.web.entity.user.User;
import com.hanghae99.wanted.web.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Transactional
    public UserResponse signup(UserRequest userRequest) {
        //TODO user 리퀘스트에서 id가 아니라 이메일을 찾아야 함
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }
        User user = userRequest.toUser(passwordEncoder);
        return UserResponse.of(userRepository.save(user));
    }

    @Transactional
    public TokenResponse login(UserRequest userRequest) {
        // 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = userRequest.toAuthentication();

        // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
        //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 access 토큰 생성하고 보내준다
        // 5. 토큰 발급
        return tokenProvider.generateTokenDto(authentication);
    }
}