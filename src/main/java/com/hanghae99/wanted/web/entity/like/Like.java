package com.hanghae99.wanted.web.entity.like;

import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import com.hanghae99.wanted.web.entity.opening.Opening;
import com.hanghae99.wanted.web.entity.user.User;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/07/16
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Like extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    private User user;

    @ManyToOne (fetch = FetchType.LAZY)
    private Opening opening;

    @Builder
    public Like ( User user, Opening opening ) {
        this.user = user;
        this.opening = opening;
    }
}
