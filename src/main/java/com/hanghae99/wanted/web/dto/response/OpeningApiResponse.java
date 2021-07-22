package com.hanghae99.wanted.web.dto.response;

import com.hanghae99.wanted.web.entity.opening.Opening;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/07/17
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class OpeningApiResponse {

    private Long openingId;
    private Long jobGroupId;
    private String imgUrl;
    private String title;
    private String companyName;
    private String location;
    private boolean liked;
    private int likeCount;

    @Builder
    public OpeningApiResponse ( Long openingId, Long jobGroupId, String imgUrl, String title,
        String companyName, String location, boolean liked, int likeCount ) {
        this.openingId = openingId;
        this.jobGroupId = jobGroupId;
        this.imgUrl = imgUrl;
        this.title = title;
        this.companyName = companyName;
        this.location = location;
        this.liked = liked;
        this.likeCount = likeCount;
    }


    public static OpeningApiResponse of ( Opening opening ) {
        return OpeningApiResponse.builder()
            .openingId(opening.getId())
            .jobGroupId(opening.getJobGroup().getId())
            .imgUrl(opening.getImgUrl())
            .title(opening.getTitle())
            .companyName(opening.getCompany().getName())
            .location(opening.getCompany().getAddress())
            .liked(opening.isLiked())
            .likeCount(opening.getLikeCount())
            .build();
    }
}
