package com.example.courseapi.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String username;
    private String email;
    private String avatar;
}

