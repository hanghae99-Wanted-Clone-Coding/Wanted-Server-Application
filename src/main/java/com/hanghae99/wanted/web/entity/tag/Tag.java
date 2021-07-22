package com.hanghae99.wanted.web.entity.tag;

import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import com.hanghae99.wanted.web.entity.opening.Opening;
import com.hanghae99.wanted.web.entity.tagCategory.TagCategory;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * CloneProject.TAG_TB와 매핑되는 Entity 클래스입니다. Created by Bloo, 21/07/16
 * @author Bloo
 * @author Seungyeon Kang
 */

@EqualsAndHashCode(of = "name")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "TAG_TB")
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JoinColumn(name = "OPENING_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Opening opening;

    @JoinColumn(name = "TAG_CTGRY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private TagCategory tagCategory;

    @Builder
    public Tag(String name, Opening opening, TagCategory tagCategory) {
        this.name = name;
        this.opening = opening;
        this.tagCategory = tagCategory;
    }
}

