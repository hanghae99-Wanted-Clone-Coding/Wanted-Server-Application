package com.hanghae99.wanted.web.entity.company;

import com.hanghae99.wanted.web.entity.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/07/16
 */


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Company extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String introduce;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String addressDetail;

    @Column(nullable = true)
    private String imgUrl;

    @Column(nullable = false)
    private int salaryAvg;

    @Column(nullable = false)
    private int employCnt;

    @Builder
    public Company ( String name, String introduce, String address, String addressDetail,
        String imgUrl, int salaryAvg, int employCnt ) {
        this.name = name;
        this.introduce = introduce;
        this.address = address;
        this.addressDetail = addressDetail;
        this.imgUrl = imgUrl;
        this.salaryAvg = salaryAvg;
        this.employCnt = employCnt;
    }
}
