package com.hanghae99.wanted.web.entity.jobgroup;

import com.hanghae99.wanted.web.entity.BaseTimeEntity;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * CloneProject.JOB_GROUP_TB와 매핑되는 Entity 클래스입니다. Created by Bloo, 21/07/16
 * @author Bloo
 * @author Seungyeon Kang
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "JOB_GROUP_TB")
public class JobGroup extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "NAME")
    private String name;

    @Builder
    public JobGroup ( String name ) {
        this.name = name;
    }
}
