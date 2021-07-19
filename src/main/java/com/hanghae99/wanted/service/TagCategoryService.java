package com.hanghae99.wanted.service;

import com.hanghae99.wanted.web.dto.response.TagCategoryResponse;
import com.hanghae99.wanted.web.entity.tagCategory.TagCategoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Created by Bloo
 * @Date: 2021/07/19
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class TagCategoryService {

    private final TagCategoryRepository tagCategoryRepository;

    public List<TagCategoryResponse> findAllCategories () {
        return tagCategoryRepository.findAll()
            .stream()
            .map(TagCategoryResponse::of)
            .collect(Collectors.toList());
    }

}
