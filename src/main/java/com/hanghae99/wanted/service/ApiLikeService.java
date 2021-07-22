package com.hanghae99.wanted.service;

import com.hanghae99.wanted.exception.OpeningNotFoundException;
import com.hanghae99.wanted.web.entity.like.Like;
import com.hanghae99.wanted.web.entity.like.LikeRepository;
import com.hanghae99.wanted.web.entity.opening.Opening;
import com.hanghae99.wanted.web.entity.opening.OpeningRepository;
import com.hanghae99.wanted.web.entity.user.User;
import com.hanghae99.wanted.web.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Created by Bloo
 * @Date: 2021/07/22
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class ApiLikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final OpeningRepository openingRepository;

    @Transactional
    public void doLike ( Long openingId, UserDetails userDetails ) {
        String userId = userDetails.getUsername();
        Long id = Long.parseLong(userId);

        // 과연 UserRepo까지 가서 user 를 찾아야 하나 이미 User는 등록된 유저임을 시큐리티가 증명해주고 있음
        // 하지만 현재 매핑은 User 가 매핑 되어 있기 때문에 User 를 반드시 찾아햐 하는 번거러움과 오버헤드가 존재

        User user = userRepository.findById(id).get();

        Opening opening = openingRepository.findById(openingId)
            .orElseThrow(OpeningNotFoundException::new);

        opening.increaseLikeCnt();

        Like like = Like.builder()
            .opening(opening)
            .user(user)
            .build();

        likeRepository.save(like);
    }
}
