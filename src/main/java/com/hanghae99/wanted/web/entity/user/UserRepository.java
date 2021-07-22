package com.hanghae99.wanted.web.entity.user;

import java.util.List;
import javax.jws.soap.SOAPBinding.Use;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * User JPA Repository
 * @Author: 강승연
 */


public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    Optional<User> findById (Long id);
}
