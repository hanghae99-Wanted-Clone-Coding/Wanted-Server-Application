package com.hanghae99.wanted.web.dto.response;

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
public class Pagination {

    private Integer totalPages;
    private Long totalElements;
    private Integer currentPage;
    private Integer currentElements;

    @Builder
    public Pagination ( Integer totalPages, Long totalElements, Integer currentPage,
        Integer currentElements ) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.currentElements = currentElements;
    }
}
