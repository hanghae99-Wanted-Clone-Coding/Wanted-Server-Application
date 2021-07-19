package com.hanghae99.wanted.service;

import com.hanghae99.wanted.web.dto.response.OpeningApiPagingResponse;
import com.hanghae99.wanted.web.dto.response.OpeningApiResponse;
import com.hanghae99.wanted.web.dto.response.Pagination;
import com.hanghae99.wanted.web.entity.opening.Opening;
import com.hanghae99.wanted.web.entity.opening.OpeningRepository;
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

    @Transactional(readOnly = true)
    public OpeningApiPagingResponse findAllOpeningUsePaging( Pageable pageable )  {
        Page<Opening> openings =  openingRepository.findAll(pageable);
        List<OpeningApiResponse> openingApiResponses = createOpeningApiResponses(openings);
        Pagination pagination = createPagination(openings);

        return OpeningApiPagingResponse.of (pagination, openingApiResponses);
    }

    @Transactional(readOnly = true)
    public OpeningApiPagingResponse findAllOpeningsByJobGroupId(Long id, Pageable pageable) {
        Page<Opening> openings = openingRepository.findAllByJobGroupId(id, pageable);
        List<OpeningApiResponse> openingApiResponses = createOpeningApiResponses(openings);
        Pagination pagination = createPagination(openings);

        return OpeningApiPagingResponse.of (pagination, openingApiResponses);
    }



    private Pagination createPagination ( Page<Opening> openings ) {
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
