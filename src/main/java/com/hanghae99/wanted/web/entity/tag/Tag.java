package com.hanghae99.wanted.web.entity.tag;

import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import com.hanghae99.wanted.web.entity.opening.Opening;
import com.hanghae99.wanted.web.entity.tagCategory.TagCategory;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * CloneProject.TAG_TB와 매핑되는 Entity 클래스입니다. Created by Bloo, 21/07/16
 * @author Bloo
 * @author Seungyeon Kang
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "TAG_TB")
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    // TODO: DB 변경에 따른 주석 처리되는 것이 맞는지 확인하기
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Opening opening;
//
//    @ManyToOne (fetch = FetchType.LAZY)
//    private TagCategory tagCategory;

    @Builder
    public Tag ( String name) {
        this.name = name;
//        this.opening = opening;
//        this.tagCategory = tagCategory;
    }

//    @Builder
//    public Tag ( String name, Opening opening, TagCategory tagCategory ) {
//        this.name = name;
//        this.opening = opening;
//        this.tagCategory = tagCategory;
//    }
}
