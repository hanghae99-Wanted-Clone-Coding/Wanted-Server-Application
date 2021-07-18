package com.hanghae99.wanted.web.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 생성 시간과 수정 시간을 자동으로 넣기위한 엔티티입니다. Created by Bloo, 21/07/16
 * @author Bloo
 * @author Seungyeon Kang
 */
@Getter
@MappedSuperclass
@EntityListeners (AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @Column(name = "CREATED_AT")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    private LocalDateTime updatedAt;
}