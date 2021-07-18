package com.hanghae99.wanted.web.entity.opening;

import com.hanghae99.wanted.util.enumclass.ReqCareer;
import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import com.hanghae99.wanted.web.entity.company.Company;
import com.hanghae99.wanted.web.entity.jobgroup.JobGroup;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * CloneProject.OPENING_TB와 매핑되는 Entity 클래스입니다. Created by Bloo, 21/07/16
 * @author Bloo
 * @author Seungyeon Kang
 */
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Opening extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, name = "TITLE")
    private String title;

    @Column (nullable = false, columnDefinition = "TEXT", name = "CONTENT")
    private String content;

    @Column (nullable = false, name = "REQ_CAREER")
    @Enumerated (EnumType.STRING)
    private ReqCareer reqCareer;

    @Column (nullable = false, name = "IMG_URL")
    private String imgUrl;

    @Column (nullable = false, name = "LIKE_CNT")
    private int likeCount;

    @JoinColumn(name = "COMPANY_ID")
    @ManyToOne (fetch = FetchType.LAZY)
    private Company company;

    @JoinColumn (name = "JOB_GROUP_ID")
    @ManyToOne (fetch = FetchType.LAZY)
    private JobGroup jobGroup;

    @Builder
    public Opening ( String title, String content, ReqCareer reqCareer, String imgUrl, int likeCount,
        Company company, JobGroup jobGroup ) {
        this.title = title;
        this.content = content;
        this.reqCareer = reqCareer;
        this.imgUrl = imgUrl;
        this.likeCount = likeCount;
        this.company = company;
        this.jobGroup = jobGroup;
    }
}
