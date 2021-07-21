package com.hanghae99.wanted.web.controller;

import com.hanghae99.wanted.service.ApiTagService;
import com.hanghae99.wanted.web.dto.response.TagResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by Bloo
 * @Date: 2021/07/19
 */

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/tags")
@RestController
public class ApiTagController {

    private final ApiTagService tagService;

    /**
     *  Tag Category 별 Tag 조회
     */
    @GetMapping("/{tag-category-id}")
    public ResponseEntity<List<TagResponse>> findTagByCategoryId(@PathVariable("tag-category-id") Long id ) {
        return ResponseEntity.ok().body(tagService.findTagByCategoryId(id));
    }
}
