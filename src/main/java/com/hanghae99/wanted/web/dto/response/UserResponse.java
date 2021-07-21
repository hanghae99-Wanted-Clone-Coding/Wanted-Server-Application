package com.hanghae99.wanted.web.dto.response;

import com.hanghae99.wanted.web.entity.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserResponse {

    private Long id;
    private String nickName;
    private String email;

    @Builder
    public UserResponse ( Long id, String nickName ) {
        this.id = id;
        this.nickName = nickName;
    }

    public static UserResponse of ( User user ) {
        return UserResponse.builder()
                .id(user.getId())
                .nickName(user.getNickName())
                .build();
    }
}