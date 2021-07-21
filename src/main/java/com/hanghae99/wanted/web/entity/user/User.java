package com.hanghae99.wanted.web.entity.user;

import javax.persistence.*;

import com.hanghae99.wanted.util.enumclass.UserRole;
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

    @Column(nullable = false, name = "EMAIL")
    private String email;

    @Column(nullable = false, name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PROFILE_URL")
    private String profileUrl;

    // TODO: 2021.07.16 -Blue  Security  세팅 후 적용 해주세요
    //TODO: 07.20 enumerated class 구조 관련 얘기해보기
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Builder
    public User ( String email, String password, String nickName, String profileUrl, UserRole userRole ) {
        this.email = email;
        this.password = password;
        this.profileUrl = profileUrl;
        this.userRole = userRole;
    }

    @Builder(builderMethodName = "kakaoUserBuilder")
    public User ( Long kakaoId, String email, String password, String nickName,
        String profileUrl, UserRole userRole ) {
        this.email = email;
        this.password = password;
        this.profileUrl = profileUrl;
        this.userRole = userRole;
    }
}
