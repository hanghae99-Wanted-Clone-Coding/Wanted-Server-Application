package com.hanghae99.wanted.exception;

/**
 * @Created by Bloo
 * @Date: 2021/07/21
 */


public class TagCategoryNotFoundException extends RuntimeException {
    private static final String MESSAGE = "해당 태그 카테고리 Id는 존재 하지 않습니다.";
    public TagCategoryNotFoundException () {
        super(MESSAGE);
    }
}
