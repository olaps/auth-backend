package com.auth.demo.payload;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
} 