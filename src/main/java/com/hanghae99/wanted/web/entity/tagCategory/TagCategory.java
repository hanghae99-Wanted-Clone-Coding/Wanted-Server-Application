package com.hanghae99.wanted.web.entity.tagCategory;

import com.hanghae99.wanted.web.entity.BaseTimeEntity;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * CloneProject.TAG_CATEGORY_TB와 매핑되는 Entity 클래스입니다. Created by Bloo, 21/07/16
 * @author Bloo
 * @author Seungyeon Kang
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "TAG_CATEGORY_TB")
public class TagCategory extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "NAME")
    private String name;

    @Builder
    public TagCategory ( String name ) {
        this.name = name;
    }
}
