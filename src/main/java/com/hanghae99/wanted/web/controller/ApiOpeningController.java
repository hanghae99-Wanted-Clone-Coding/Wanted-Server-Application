package com.hanghae99.wanted.web.controller;

import com.hanghae99.wanted.service.ApiOpeningService;
import com.hanghae99.wanted.util.enumclass.ReqCareer;
import com.hanghae99.wanted.web.dto.response.OpeningApiDetailResponse;
import com.hanghae99.wanted.web.dto.response.OpeningApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by Bloo
 * @Date: 2021/07/17
 */


@Slf4j
@RequiredArgsConstructor
@RestController
public class ApiOpeningController {

    private final ApiOpeningService openingService;

    /**
     * 채용공지 최신 순 조회
     */
    @GetMapping ("/api/openings")
    public ResponseEntity<List<OpeningApiResponse>> findAllOpeningUsePaging () {
        return ResponseEntity.ok().body(openingService.findAllOpeningUsePaging());
    }

    /**
     * Job Group 별 채용공고 조회
     * 성공
     */
    @GetMapping ("/api/jobgroup/{jobgroup-id}")
    public ResponseEntity<List<OpeningApiResponse>> findAllOpeningsByJobGroupId (
        @PathVariable (name = "jobgroup-id") Long id) {
        log.info("Job Group Id >>> {}", id);
        return ResponseEntity.ok().body(openingService.findAllOpeningsByJobGroupId(id));
    }

    /**
     * 경력 별 채용공고 조회
     * 성공
     *
     */
    @GetMapping ("/api/career")
    public ResponseEntity<List<OpeningApiResponse>> findAllOpeningsByCareer ( @RequestParam ("career") ReqCareer reqCareer) {

        log.info("Req Career >>> {}", reqCareer);
        return ResponseEntity.ok().body(openingService.findAllOpeningsByCareer(reqCareer));
    }

    /**
     *  태그 명으로 채용공고 조회
     *
     */
    @GetMapping("/api/search")
    public ResponseEntity<List<OpeningApiResponse>> findAllOpeningsByTag(
        @RequestParam("tagName") String tagName) {
        log.info("Tag Name >>> {}", tagName);
        return ResponseEntity.ok().body(openingService.findAllOpeningByTagName(tagName));
    }

    /**
     * 채용공고 상세 조회 구현
     */
    @GetMapping("/api/openings/{id}")
    public ResponseEntity<OpeningApiDetailResponse> findById(@PathVariable Long id) {
        log.info("ID >>>> {}", id);
        return ResponseEntity.ok().body(openingService.findOpeningDetailById(id));
    }
}
