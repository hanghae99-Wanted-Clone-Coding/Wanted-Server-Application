package com.hanghae99.wanted.web.entity.opening;

import com.hanghae99.wanted.util.enumclass.ReqCareer;
import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/07/16
 */


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Opening extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReqCareer reqCareer;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private int likeCount;
}
