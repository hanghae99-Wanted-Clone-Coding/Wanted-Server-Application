package com.hanghae99.wanted.web.entity.user;

import javax.jws.soap.SOAPBinding.Use;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * User JPA Repository
 * @Author: 강승연
 */


public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
