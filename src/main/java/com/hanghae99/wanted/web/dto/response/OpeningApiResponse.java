package com.hanghae99.wanted.web.dto.response;

import com.hanghae99.wanted.web.entity.opening.Opening;
import java.time.LocalDateTime;
import java.util.stream.LongStream;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * @Created by Bloo
 * @Date: 2021/07/17
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class OpeningApiResponse {

    private Long openingId;
    private Long jobGroupId;
    @Setter
    private Long likedId;
    private String imgUrl;
    private String title;
    private String companyName;
    private String location;
    private int likeCount;

    @Builder
    public OpeningApiResponse ( Long openingId, Long jobGroupId, Long likedId, String imgUrl, String title,
        String companyName, String location, int likeCount ) {
        this.openingId = openingId;
        this.jobGroupId = jobGroupId;
        this.likedId = likedId;
        this.imgUrl = imgUrl;
        this.title = title;
        this.companyName = companyName;
        this.location = location;
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
            .likeCount(opening.getLikeCount())
            .build();
    }
}
