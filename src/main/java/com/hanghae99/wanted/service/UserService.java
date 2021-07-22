package com.hanghae99.wanted.service;

import com.hanghae99.wanted.util.SecurityUtil;
import com.hanghae99.wanted.web.dto.response.MyPageInfoResponse;
import com.hanghae99.wanted.web.dto.response.OpeningApiResponse;
import com.hanghae99.wanted.web.dto.response.TagResponse;
import com.hanghae99.wanted.web.dto.response.UserResponse;
import com.hanghae99.wanted.web.entity.like.Like;
import com.hanghae99.wanted.web.entity.like.LikeRepository;
import com.hanghae99.wanted.web.entity.opening.Opening;
import com.hanghae99.wanted.web.entity.opening.OpeningRepository;
import com.hanghae99.wanted.web.entity.user.User;
import com.hanghae99.wanted.web.entity.user.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final OpeningRepository openingRepository;

    @Transactional(readOnly = true)
    public UserResponse getMemberInfo(String email) {
        return userRepository.findByEmail(email)
                .map(UserResponse::of)
                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }

    // 현재 SecurityContext 에 있는 유저 정보 가져오기
    @Transactional(readOnly = true)
    public UserResponse getMyInfo() {
        return userRepository.findById(SecurityUtil.getCurrentMemberId().toString())
                .map(UserResponse::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }


    @Transactional(readOnly = true)
    public MyPageInfoResponse getMyInfos ( UserDetails userDetails ) {
        String userId = userDetails.getUsername();
        Long id = Long.parseLong(userId);

        // 과연 UserRepo까지 가서 user 를 찾아야 하나 이미 User는 등록된 유저임을 시큐리티가 증명해주고 있음
        // 하지만 현재 매핑은 User 가 매핑 되어 있기 때문에 User 를 반드시 찾아햐 하는 번거러움과 오버헤드가 존재

        User user = userRepository.findById(id).get();
        String email = user.getEmail();
        String name = user.getName();

        List<Like> likes = likeRepository.findAllByUser(user);

        for (Like like : likes) {

        }

        List<OpeningApiResponse> openingApiResponses = likes
            .stream()
            .map(Like::getOpening)

            .map(OpeningApiResponse::of)
            .collect(Collectors.toList());

        return MyPageInfoResponse.of (email, name, openingApiResponses);
    }
}
