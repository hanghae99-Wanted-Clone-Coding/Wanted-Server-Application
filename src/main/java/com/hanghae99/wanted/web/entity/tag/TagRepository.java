package com.hanghae99.wanted.web.entity.tag;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CloneProject.TAG_TB(Tag) 객체에 대한 CRUD룰 위한 JPA Repository입니다. Created by Bloo, 21/07/16
 * @author Bloo
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    public List<Tag> findAllByCategoryId (Long categoryId);
}
