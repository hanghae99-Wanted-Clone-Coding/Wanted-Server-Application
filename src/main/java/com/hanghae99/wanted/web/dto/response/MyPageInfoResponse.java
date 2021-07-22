package com.hanghae99.wanted.web.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/07/22
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MyPageInfoResponse {

    private String email;
    private List<OpeningApiResponse> openingApiResponses;

    public static MyPageInfoResponse of (String email, List<OpeningApiResponse> openingApiResponses) {
        return new MyPageInfoResponse(email, openingApiResponses);
    }
}
