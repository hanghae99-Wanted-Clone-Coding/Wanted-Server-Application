package com.hanghae99.wanted.web.dto.response;

import com.hanghae99.wanted.web.entity.jobgroup.JobGroup;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/07/17
 */


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class JobGroupResponse {

    private Long groupId;
    private String name;

    @Builder
    public JobGroupResponse ( Long groupId, String name ) {
        this.groupId = groupId;
        this.name = name;
    }

    public static JobGroupResponse of ( JobGroup jobGroup ) {
        return JobGroupResponse.builder()
            .groupId(jobGroup.getId())
            .name(jobGroup.getName())
            .build();
    }
}
