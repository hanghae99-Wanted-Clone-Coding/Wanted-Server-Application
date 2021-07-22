package com.hanghae99.wanted.service;

import com.hanghae99.wanted.exception.OpeningNotFoundException;
import com.hanghae99.wanted.util.enumclass.ReqCareer;
import com.hanghae99.wanted.web.dto.response.OpeningApiDetailResponse;
import com.hanghae99.wanted.web.dto.response.OpeningApiResponse;
import com.hanghae99.wanted.web.dto.response.TagResponse;
import com.hanghae99.wanted.web.entity.opening.Opening;
import com.hanghae99.wanted.web.entity.opening.OpeningRepository;
import com.hanghae99.wanted.web.entity.tag.Tag;
import com.hanghae99.wanted.web.entity.tag.TagRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Created by Bloo
 * @Date: 2021/07/17
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class ApiOpeningService {

    private final OpeningRepository openingRepository;
    private final TagRepository tagRepository;

    /**
     * 모든 채용공고 최신순 조회
     */
    @Transactional(readOnly = true)
    public List<OpeningApiResponse> findAllOpeningUsePaging( Pageable pageable )  {
        //TODO No enum constant com.hanghae99.wanted.util.enumclass.ReqCareer.career
        Page<Opening> openings =  openingRepository.findAll(pageable);

        return createOpeningApiResponses(openings);
    }

    /**
     * Job Group 별 채용공고 조회
     */
    @Transactional(readOnly = true)
    public List<OpeningApiResponse> findAllOpeningsByJobGroupId(Long id, Pageable pageable) {
        Page<Opening> openings = openingRepository.findAllByJobGroupId(id, pageable);
        List<OpeningApiResponse> openingApiResponses = createOpeningApiResponses(openings);

        return createOpeningApiResponses(openings);
    }

    /**
     * 경력별 채용공고 조회
     */
    @Transactional(readOnly = true)
    public List<OpeningApiResponse> findAllOpeningsByCareer ( ReqCareer reqCareer, Pageable pageable ) {
        Page<Opening> openings = openingRepository.findAllByReqCareer(reqCareer, pageable);

        return createOpeningApiResponses(openings);
    }

    /**
     * 태그 이름 기반 Opening 검색
     */
    @Transactional(readOnly = true)
    public List<OpeningApiResponse> findAllOpeningByTagName ( String name, Pageable pageable ) {
        Page<Tag> tags = tagRepository.findAllByName(name, pageable);

        List<OpeningApiResponse> openingApiResponses = tags
            .stream()
            .map(Tag::getOpening)
            .map(OpeningApiResponse::of)
            .collect(Collectors.toList());

        return openingApiResponses;
    }

    @Transactional
    public OpeningApiDetailResponse findOpeningDetailById ( Long id ) {
        Opening opening = openingRepository.findById(id).orElseThrow(OpeningNotFoundException::new);
        log.info("############ opening Content >>> {}", opening.getContent());
        List<Tag> tags = tagRepository.findAllByOpening(opening);

        List<TagResponse> tagResponse = tags
            .stream()
            .map(TagResponse::of)
            .collect(Collectors.toList());
        return OpeningApiDetailResponse.of (opening, tagResponse);
    }


    private List<OpeningApiResponse> createOpeningApiResponses ( Page<Opening> openings ) {
        return openings
            .stream()
            .map(OpeningApiResponse::of)
            .collect(Collectors.toList());
    }
}
