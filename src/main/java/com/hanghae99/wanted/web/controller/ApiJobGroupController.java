package com.hanghae99.wanted.web.controller;

import com.hanghae99.wanted.service.ApiJobGroupService;
import com.hanghae99.wanted.web.dto.response.JobGroupResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by Bloo
 * @Date: 2021/07/17
 */

@Slf4j
@RequestMapping("/api/job-groups")
@RequiredArgsConstructor
@RestController
public class ApiJobGroupController {

    private final ApiJobGroupService apiJobGroupService;

    @Cacheable(value = "jobGroup")
    @GetMapping("")
    public ResponseEntity<List<JobGroupResponse>> finAll() {
        return ResponseEntity.ok().body(apiJobGroupService.findAll());
    }
}
