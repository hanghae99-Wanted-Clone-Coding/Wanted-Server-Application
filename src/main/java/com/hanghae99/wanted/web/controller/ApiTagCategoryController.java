package com.hanghae99.wanted.web.controller;

import com.hanghae99.wanted.service.TagCategoryService;
import com.hanghae99.wanted.web.dto.response.TagCategoryResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by Bloo
 * @Date: 2021/07/19
 */

@Slf4j
@RequestMapping ("/api/tag-categories")
@RequiredArgsConstructor
@RestController
public class ApiTagCategoryController {

    private final TagCategoryService tagCategoryService;

    @GetMapping("")
    public ResponseEntity<List<TagCategoryResponse>> findAllTagCategories () {
        return ResponseEntity.ok().body(tagCategoryService.findAllCategories());
    }
}
