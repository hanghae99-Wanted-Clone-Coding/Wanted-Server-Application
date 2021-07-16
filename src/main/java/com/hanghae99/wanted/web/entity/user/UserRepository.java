package com.hanghae99.wanted.web.entity.user;

import javax.jws.soap.SOAPBinding.Use;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Created by Bloo
 * @Date: 2021/07/16
 */


public interface UserRepository extends JpaRepository<User, Long> {

}
