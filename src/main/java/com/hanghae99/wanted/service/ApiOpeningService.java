package com.hanghae99.wanted.service;

import com.hanghae99.wanted.exception.OpeningNotFoundException;
import com.hanghae99.wanted.util.enumclass.ReqCareer;
import com.hanghae99.wanted.web.dto.response.OpeningApiDetailResponse;
import com.hanghae99.wanted.web.dto.response.OpeningApiPagingResponse;
import com.hanghae99.wanted.web.dto.response.OpeningApiResponse;
import com.hanghae99.wanted.web.dto.response.Pagination;
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
    public OpeningApiPagingResponse findAllOpeningUsePaging( Pageable pageable )  {
        //TODO No enum constant com.hanghae99.wanted.util.enumclass.ReqCareer.career
        Page<Opening> openings =  openingRepository.findAll(pageable);
        List<OpeningApiResponse> openingApiResponses = createOpeningApiResponses(openings);
        Pagination pagination = createPagination(openings);

        return OpeningApiPagingResponse.of (pagination, openingApiResponses);
    }

    /**
     * Job Group 별 채용공고 조회
     */
    @Transactional(readOnly = true)
    public OpeningApiPagingResponse findAllOpeningsByJobGroupId(Long id, Pageable pageable) {
        Page<Opening> openings = openingRepository.findAllByJobGroupId(id, pageable);
        List<OpeningApiResponse> openingApiResponses = createOpeningApiResponses(openings);
        Pagination pagination = createPagination(openings);

        return OpeningApiPagingResponse.of (pagination, openingApiResponses);
    }

    /**
     * 경력별 채용공고 조회
     */
    @Transactional(readOnly = true)
    public OpeningApiPagingResponse findAllOpeningsByCareer ( ReqCareer reqCareer, Pageable pageable ) {
        Page<Opening> openings = openingRepository.findAllByReqCareer(reqCareer, pageable);
        List<OpeningApiResponse> openingApiResponses = createOpeningApiResponses(openings);
        Pagination pagination = createPagination(openings);

        return OpeningApiPagingResponse.of (pagination, openingApiResponses);
    }

    /**
     * 태그 이름 기반 Opening 검색
     */
    @Transactional(readOnly = true)
    public OpeningApiPagingResponse findAllOpeningByTagName ( String name, Pageable pageable ) {
        Page<Tag> tags = tagRepository.findAllByName(name, pageable);

        List<OpeningApiResponse> openingApiResponses = tags
            .stream()
            .map(Tag::getOpening)
            .map(OpeningApiResponse::of)
            .collect(Collectors.toList());

        Pagination pagination = createPagination(tags);

        return OpeningApiPagingResponse.of (pagination, openingApiResponses);
    }

    @Transactional
    public OpeningApiDetailResponse findOpeningDetailById ( Long id ) {
        Opening opening = openingRepository.findById(id).orElseThrow(OpeningNotFoundException::new);
        List<Tag> tags = tagRepository.findAllByOpeningId(id);

        return OpeningApiDetailResponse.of (opening, tags);
    }

    private Pagination createPagination ( Page<?> openings ) {
        return Pagination.builder()
            .totalPages(openings.getTotalPages())
            .totalElements(openings.getTotalElements())
            .currentPage(openings.getTotalPages())
            .currentElements(openings.getNumberOfElements())
            .build();
    }

    private List<OpeningApiResponse> createOpeningApiResponses ( Page<Opening> openings ) {
        return openings
            .stream()
            .map(OpeningApiResponse::of)
            .collect(Collectors.toList());
    }
}
