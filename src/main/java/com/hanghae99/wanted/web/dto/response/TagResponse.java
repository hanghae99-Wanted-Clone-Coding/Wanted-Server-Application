package com.hanghae99.wanted.web.dto.response;

import com.hanghae99.wanted.web.entity.tag.Tag;
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
public class TagResponse {

    private Long id;
    private String name;

    @Builder
    public TagResponse ( Long id, String name ) {
        this.id = id;
        this.name = name;
    }

    public static TagResponse of ( Tag tag ) {
        return TagResponse.builder()
            .id(tag.getId())
            .name(tag.getName())
            .build();
    }
}
