package com.auth.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/public")
public class PublicController {

    @GetMapping("/info")
    public String info() {
        return "This is a public information endpoint";
    }
} 