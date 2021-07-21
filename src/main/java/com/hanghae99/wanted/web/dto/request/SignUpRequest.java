package com.hanghae99.wanted.web.dto.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpRequest {
    private String username;
    private String password;
    private String email;
    private boolean admin = false;
    private String adminToken = "";
}
