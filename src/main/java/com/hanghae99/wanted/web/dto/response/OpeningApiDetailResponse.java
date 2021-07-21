package com.hanghae99.wanted.web.dto.response;

import com.hanghae99.wanted.web.entity.opening.Opening;
import com.hanghae99.wanted.web.entity.tag.Tag;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @Created by Bloo
 * @Date: 2021/07/21
 */


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class OpeningApiDetailResponse {

    @NonNull
    private String companyName;

    @NonNull
    private String imgUrl;

    @NonNull
    private String title;

    @NonNull
    private String location;

    @NonNull
    private String locationDetail;

    @NonNull
    private String content;

    @NonNull
    private int likeCnt;

    @NonNull
    private List<TagResponse> tags = new ArrayList<>();

    @Builder
    public OpeningApiDetailResponse ( String companyName, String imgUrl, String title, String location, String locationDetail, String content, int likeCnt, List<TagResponse> tagResponses ) {
        this.companyName = companyName;
        this.imgUrl = imgUrl;
        this.title = title;
        this.location = location;
        this.locationDetail = locationDetail;
        this.content = content;
        this.likeCnt = likeCnt;
        this.tags = tagResponses;
    }

    public static OpeningApiDetailResponse of ( Opening opening, List<TagResponse> tagResponses) {
        return OpeningApiDetailResponse.builder()
            .companyName(opening.getCompany().getName())
            .content(opening.getContent())
            .imgUrl(opening.getImgUrl())
            .title(opening.getTitle())
            .location(opening.getLocation())
            .locationDetail(opening.getLocationDetail())
            .likeCnt(opening.getLikeCount())
            .tagResponses(tagResponses)
            .build();
    }
}
