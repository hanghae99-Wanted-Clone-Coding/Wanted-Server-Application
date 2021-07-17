package com.hanghae99.wanted.service;

import com.hanghae99.wanted.web.dto.response.JobGroupResponse;
import com.hanghae99.wanted.web.entity.jobgroup.JobGroupRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Created by Bloo
 * @Date: 2021/07/17
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class ApiJobGroupService {

    private final JobGroupRepository groupRepository;

    @Transactional(readOnly = true)
    public List<JobGroupResponse> findAll() {
        return groupRepository.findAll()
            .stream()
            .map(JobGroupResponse::of)
            .collect(Collectors.toList());
    }
}
