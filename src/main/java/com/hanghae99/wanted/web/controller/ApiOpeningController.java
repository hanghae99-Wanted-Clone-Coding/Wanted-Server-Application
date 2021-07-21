package com.hanghae99.wanted.web.controller;

import com.hanghae99.wanted.service.ApiOpeningService;
import com.hanghae99.wanted.web.dto.response.OpeningApiPagingResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by Bloo
 * @Date: 2021/07/17
 */


@Slf4j
@RequiredArgsConstructor
@RequestMapping ("/api/openings")
@RestController
public class ApiOpeningController {

    private final ApiOpeningService openingService;

    /**
     * 채용공지 최신 순 조회
     */
    @GetMapping ("")
    public ResponseEntity<OpeningApiPagingResponse> findAllOpeningUsePaging (
        @PageableDefault (size = 20, sort = { "createdAt" }, direction = Direction.DESC) Pageable pageable ) {
        return ResponseEntity.ok().body(openingService.findAllOpeningUsePaging(pageable));
    }

    /**
     * Job Group 별 채용공고 조회
     */
    @GetMapping ("/{jobgroup-id}")
    public ResponseEntity<OpeningApiPagingResponse> findAllOpeningsByJobGroupId (
        @PathVariable (name = "jobgroup-id") Long id,
        @PageableDefault (size = 20, sort = { "createdAt" }, direction = Direction.DESC) Pageable pageable ) {
        return ResponseEntity.ok().body(openingService.findAllOpeningsByJobGroupId(id, pageable));
    }

    /**
     * 경력 별 채용공고 조회
     */
    @GetMapping ("{req-career}")
    public ResponseEntity<OpeningApiPagingResponse> findAllOpeningsByCareer (
        @PathVariable ("req-career") String reqCareer,
        @PageableDefault (size = 20, sort = { "createdAt" }, direction = Direction.DESC) Pageable pageable ) {
        return ResponseEntity.ok().body(openingService.findAllOpeningsByCareer(reqCareer, pageable));
    }
}
