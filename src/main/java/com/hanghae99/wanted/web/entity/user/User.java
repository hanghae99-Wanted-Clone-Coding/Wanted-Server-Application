package com.hanghae99.wanted.web.entity.user;

import javax.persistence.*;

import com.hanghae99.wanted.util.enumclass.UserRole;
import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Column(nullable = false, name = "NAME")
    private String name;

    @Column(nullable = false, name = "EMAIL")
    private String email;

    @Column(nullable = false, name = "PASSWORD")
    private String password;

    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Builder
    public User ( String email, String password, String name, UserRole userRole ) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.userRole = userRole;
    }
}
