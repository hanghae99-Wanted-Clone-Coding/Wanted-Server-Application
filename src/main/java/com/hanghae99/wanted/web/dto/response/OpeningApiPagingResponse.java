package com.hanghae99.wanted.web.dto.response;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/07/17
 */


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class OpeningApiPagingResponse {

    private Pagination pagination;
    private List<OpeningApiResponse> openingApiResponses;

    public OpeningApiPagingResponse ( Pagination pagination, List<OpeningApiResponse> openingApiResponses ) {
        this.pagination = pagination;
        this.openingApiResponses = openingApiResponses;
    }

    public static OpeningApiPagingResponse of (Pagination pagination, List<OpeningApiResponse> openingApiResponses ) {
        return new OpeningApiPagingResponse(pagination,openingApiResponses);
    }
}
