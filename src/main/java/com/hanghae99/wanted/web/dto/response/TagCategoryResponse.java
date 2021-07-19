package com.hanghae99.wanted.web.dto.response;

import com.hanghae99.wanted.web.entity.tagCategory.TagCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/07/19
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class TagCategoryResponse {
    private Long id;
    private String name;

    @Builder
    public TagCategoryResponse ( Long id, String name ) {
        this.id = id;
        this.name = name;
    }

    public static TagCategoryResponse of ( TagCategory tagCategory ){
        return TagCategoryResponse.builder()
            .id(tagCategory.getId())
            .name(tagCategory.getName())
            .build();
    }
}
