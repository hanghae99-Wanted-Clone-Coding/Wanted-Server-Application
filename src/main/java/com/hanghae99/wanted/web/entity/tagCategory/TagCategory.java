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
 * 상위 카테고리 클래스는 사용하지 않을 것으로 예상됩니다. Created by Bloo, 21/07/17
 * @deprecated
 * @author Bloo
 * @author Seungyeon Kang
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
