package com.hanghae99.wanted.web.entity.tag;

import com.hanghae99.wanted.web.entity.tagCategory.TagCategory;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CloneProject.TAG_TB(Tag) 객체에 대한 CRUD룰 위한 JPA Repository입니다. Created by Bloo, 21/07/16
 *
 * @author Bloo
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findAllByTagCategory ( TagCategory tagCategory );

    Page<Tag> findAllByName ( String name, Pageable pageable );
}
