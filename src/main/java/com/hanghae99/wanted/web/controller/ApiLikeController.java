package com.hanghae99.wanted.web.controller;

import com.hanghae99.wanted.service.ApiLikeService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by Bloo
 * @Date: 2021/07/22
 */


@Slf4j
@RequestMapping ("/api/openings/{id}/like")
@RequiredArgsConstructor
@RestController
public class ApiLikeController {

    private final ApiLikeService apiLikeService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping ("")
    public ResponseEntity<Void> doLike (@PathVariable("id") Long openingId, @AuthenticationPrincipal UserDetails userDetails){
        apiLikeService.doLike(openingId, userDetails);
        return ResponseEntity.ok().build();
    }
}
