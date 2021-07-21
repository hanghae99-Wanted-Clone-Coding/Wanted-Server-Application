package com.hanghae99.wanted.web.dto.response;

import com.hanghae99.wanted.web.entity.opening.Opening;
import com.hanghae99.wanted.web.entity.tag.Tag;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/07/21
 */


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class OpeningApiDetailResponse {

    private String companyName;
    private String imgUrl;
    private String title;
    private String location;
    private String locationDetail;
    private String content;
    private int likeCnt;
    private List<Tag> tags = new ArrayList<>();

    @Builder
    public OpeningApiDetailResponse ( String companyName, String imgUrl, String title, String location, String locationDetail, String content, int likeCnt, List<Tag> tags ) {
        this.companyName = companyName;
        this.imgUrl = imgUrl;
        this.title = title;
        this.location = location;
        this.locationDetail = locationDetail;
        this.content = content;
        this.likeCnt = likeCnt;
        this.tags = tags;
    }

    public static OpeningApiDetailResponse of ( Opening opening, List<Tag> tags) {
        return OpeningApiDetailResponse.builder()
            .companyName(opening.getCompany().getName())
            .imgUrl(opening.getImgUrl())
            .title(opening.getTitle())
            .location(opening.getLocation())
            .locationDetail(opening.getLocationDetail())
            .likeCnt(opening.getLikeCount())
            .tags(tags)
            .build();
    }
}
