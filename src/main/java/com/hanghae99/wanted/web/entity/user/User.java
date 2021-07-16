package com.hanghae99.wanted.web.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/07/16
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private Long kakaoId;

    private String email;

    private String password;

    private String nickName;

    private String profileUrl;

    // TODO: 2021.07.16 -Blue  Security  세팅 후 적용 해주세요
    //private Set<Authority> authorities = new HashSet<>();

    @Builder
    public User ( String email, String password, String nickName, String profileUrl ) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.profileUrl = profileUrl;
    }

}
