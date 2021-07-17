package com.hanghae99.wanted.web.entity.tag;

import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import com.hanghae99.wanted.web.entity.opening.Opening;
import com.hanghae99.wanted.web.entity.tagCategory.TagCategory;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Opening opening;

    @ManyToOne (fetch = FetchType.LAZY)
    private TagCategory tagCategory;

    @Builder
    public Tag ( String name, Opening opening, TagCategory tagCategory ) {
        this.name = name;
        this.opening = opening;
        this.tagCategory = tagCategory;
    }
}
