package com.hanghae99.wanted.exception;

/**
 * @Created by Bloo
 * @Date: 2021/07/21
 */


public class OpeningNotFoundException extends RuntimeException{
    private static final String MESSAGE = "존재하지 않는 채용공고 입니다.";
    public OpeningNotFoundException () {
        super(MESSAGE);
    }
}
