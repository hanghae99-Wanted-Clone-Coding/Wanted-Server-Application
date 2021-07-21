package com.hanghae99.wanted.web.entity.like;

import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import com.hanghae99.wanted.web.entity.company.Company;
import com.hanghae99.wanted.web.entity.opening.Opening;
import com.hanghae99.wanted.web.entity.user.User;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * CloneProject.LIKE_TB와 매핑되는 Entity 클래스입니다. Created by Bloo, 21/07/16
 * @author Bloo
 * @author Seungyeon Kang
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "LIKE_TB")
public class Like extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "USER_ID")
    @ManyToOne (fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "OPENING_ID")
    @ManyToOne (fetch = FetchType.LAZY)
    private Opening opening;

    @Builder
    public Like (User user, Company company, Opening opening ) {
        this.user = user;
        this.opening = opening;
    }
}
