package com.hanghae99.wanted.web.entity.tagCategory;

import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/07/17
 */


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class TagCategory extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Builder
    public TagCategory ( String name ) {
        this.name = name;
    }
}
