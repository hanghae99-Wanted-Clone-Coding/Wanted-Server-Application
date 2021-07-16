package com.hanghae99.wanted.util.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Created by Bloo
 * @Date: 2021/07/16
 */


@AllArgsConstructor
@Getter
public enum ReqCareer {

    NEW_COMMER(1, "신입"),
    CAREER(2, "경력");

    private  final int id;
    private final String reqCareer;
}
