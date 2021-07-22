package com.hanghae99.wanted.web.entity.like;

import com.hanghae99.wanted.web.entity.opening.Opening;
import com.hanghae99.wanted.web.entity.user.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CloneProject.LIKE_TB(Like) 객체에 대한 CRUD룰 위한 JPA Repository입니다. Created by Bloo, 21/07/16
 * @author Bloo
 */
public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> findAllByUser ( User user);
}
