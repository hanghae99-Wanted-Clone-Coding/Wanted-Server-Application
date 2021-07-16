package com.hanghae99.wanted.web.entity.tag;

import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder
    public Tag ( String name ) {
        this.name = name;
    }
}
