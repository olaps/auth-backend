package com.auth.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/github")
public class GithubUserController {

    @GetMapping("/user")
    public Map<String, Object> getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
        // This endpoint is called after successful GitHub OAuth2 login
        // It returns the user's GitHub information
        return Map.of(
            "name", principal.getAttribute("name"),
            "login", principal.getAttribute("login"), // GitHub username
            "email", principal.getAttribute("email"),
            "avatar_url", principal.getAttribute("avatar_url"),
            "html_url", principal.getAttribute("html_url") // GitHub profile URL
        );
    }
} 