package com.auth.demo.payload;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
} 