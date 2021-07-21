package com.hanghae99.wanted.web.dto.request;

import com.hanghae99.wanted.util.enumclass.UserRole;
import com.hanghae99.wanted.web.entity.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserRequest {

    private String email;
    private String password;
    private String name;


    @Builder
    public UserRequest ( String email, String password, String name ) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public User toUser(PasswordEncoder passwordEncoder) {
        return User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .userRole(UserRole.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}