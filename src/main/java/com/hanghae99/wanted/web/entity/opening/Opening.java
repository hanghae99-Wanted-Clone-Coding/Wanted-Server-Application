package com.hanghae99.wanted.web.entity.opening;

import com.hanghae99.wanted.util.enumclass.ReqCareer;
import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import com.hanghae99.wanted.web.entity.company.Company;
import com.hanghae99.wanted.web.entity.jobgroup.JobGroup;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/07/16
 */


@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Opening extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private ReqCareer reqCareer;

    @Column (nullable = false)
    private String imgUrl;

    @Column (nullable = false)
    private int likeCount;

    @ManyToOne (fetch = FetchType.LAZY)
    private Company company;

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
