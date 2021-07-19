package com.hanghae99.wanted.web.entity.user;

import javax.persistence.*;

import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * CloneProject.USER_TB와 매핑되는 Entity 클래스입니다. Created by Bloo, 21/07/16
 * @author Bloo
 * @author Seungyeon Kang
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "USER_TB")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "KAKAO_ID")
    private Long kakaoId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NICK_NAME")
    private String nickName;

    @Column(name = "PROFILE_URL")
    private String profileUrl;

    @Column(name = "USER_ROLE")
    private char userRole;

    // TODO: 2021.07.16 -Blue  Security  세팅 후 적용 해주세요
    //private Set<Authority> authorities = new HashSet<>();

    @Builder
    public User ( String email, String password, String nickName, String profileUrl, char userRole ) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.profileUrl = profileUrl;
        this.userRole = userRole;
    }

    @Builder(builderMethodName = "kakaoUserBuilder")
    public User ( Long kakaoId, String email, String password, String nickName,
        String profileUrl, char userRole ) {
        this.kakaoId = kakaoId;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.profileUrl = profileUrl;
        this.userRole = userRole;
    }
}
