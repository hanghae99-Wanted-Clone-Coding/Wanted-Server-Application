package com.hanghae99.wanted.web.entity.company;

import com.hanghae99.wanted.web.entity.BaseTimeEntity;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * CloneProject.COMPANY_TB와 매핑되는 Entity 클래스입니다. Created by Bloo, 21/07/16
 * @author Bloo
 * @author Seungyeon Kang
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "COMPANY_TB")
public class Company extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "NAME")
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT", name = "INTRODUCE")
    private String introduce;

    @Column(nullable = false, name = "ADDRESS")
    private String address;

    @Column(nullable = false, name = "ADDRESS_DETAIL")
    private String addressDetail;

    @Column(nullable = true, name = "IMG_URL")
    private String imgUrl;

    @Column(nullable = false, name = "SALARY_AVG")
    private int salaryAvg;

    @Column(nullable = false, name = "EMPLOYEE_CNT")
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
