package com.auth.demo.controller;

import com.auth.demo.model.User;
import com.auth.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/protected")
public class ProtectedController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public Map<String, String> getUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        // Get the actual user from the database to retrieve email
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
                
        return Map.of(
            "username", userDetails.getUsername(),
            "email", user.getEmail()
        );
    }

    @GetMapping("/admin")
    public String getAdminInfo() {
        return "This is an admin-only endpoint.";
    }
} 