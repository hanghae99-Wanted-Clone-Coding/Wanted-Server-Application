package com.hanghae99.wanted.web.dto.response;

import com.hanghae99.wanted.util.enumclass.UserRole;
import com.hanghae99.wanted.web.entity.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private UserRole userRole;


    @Builder
    public UserResponse ( Long id, String name, String email, UserRole userRole ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userRole = userRole;
    }

    public static UserResponse of ( User user ) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}