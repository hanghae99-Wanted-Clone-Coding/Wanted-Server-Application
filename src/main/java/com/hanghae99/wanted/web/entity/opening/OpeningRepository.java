package com.hanghae99.wanted.web.entity.opening;

import com.hanghae99.wanted.util.enumclass.ReqCareer;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * CloneProject.OPENING_TB(Opening) 객체에 대한 CRUD룰 위한 JPA Repository입니다. Created by Bloo, 21/07/16
 * @author Bloo
 */
public interface OpeningRepository extends JpaRepository<Opening, Long> {
    List<Opening> findAllByJobGroupId ( Long jobGroup_id);
    List<Opening> findAllByReqCareer( ReqCareer reqCareer);
}
