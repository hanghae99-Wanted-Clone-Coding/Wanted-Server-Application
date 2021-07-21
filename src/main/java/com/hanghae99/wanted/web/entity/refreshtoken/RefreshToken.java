package com.hanghae99.wanted.web.entity.refreshtoken;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Table(name = "REFRESH_TOKEN")
@Entity
public class RefreshToken {

    @Id
    private String refreshKey;
    private String refreshValue;

    public RefreshToken updateValue(String token) {
        this.refreshKey = token;
        return this;
    }

    @Builder
    public RefreshToken(String refresh_key, String refresh_value) {
        this.refreshKey = refresh_key;
        this.refreshValue = refresh_value;
    }
}