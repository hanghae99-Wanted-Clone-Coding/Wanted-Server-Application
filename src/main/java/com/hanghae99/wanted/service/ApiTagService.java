package com.hanghae99.wanted.service;

import com.hanghae99.wanted.web.dto.response.TagResponse;
import com.hanghae99.wanted.web.entity.tag.TagRepository;
import java.util.List;
import java.util.stream.Collectors;

import com.hanghae99.wanted.web.entity.tagCategory.TagCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Created by Bloo
 * @Date: 2021/07/19
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class ApiTagService {

    private final TagRepository tagRepository;

//    @Transactional (readOnly = true)
//    public List<TagResponse> findTagByCategoryId ( Long id ) {
//        TagCategory tagCategory = id;
//        return tagRepository.findAllbyTagCategory(id)
//            .stream()
//            .map(TagResponse::of)
//            .collect(Collectors.toList());
//    }
}
