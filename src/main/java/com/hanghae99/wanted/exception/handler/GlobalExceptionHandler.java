package com.hanghae99.wanted.exception.handler;

import com.hanghae99.wanted.exception.OpeningNotFoundException;
import com.hanghae99.wanted.exception.TagCategoryNotFoundException;
import com.hanghae99.wanted.web.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Created by Bloo
 * @Date: 2021/07/21
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TagCategoryNotFoundException.class)
    public ErrorResponse handleTagCategoryNotFoundException(TagCategoryNotFoundException ex) {
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(OpeningNotFoundException.class)
    public ErrorResponse handleOpeningNotFoundException(OpeningNotFoundException ex) {
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
