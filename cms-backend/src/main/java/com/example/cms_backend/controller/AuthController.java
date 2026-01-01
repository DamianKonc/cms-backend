package com.example.cms_backend.controller;

import com.example.cms_backend.dto.RegisterRequest;
import com.example.cms_backend.dto.RegisterResponse;
import com.example.cms_backend.dto.LoginRequest;
import com.example.cms_backend.dto.LoginResponse;

import com.example.cms_backend.service.AuthService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/auth")

public class AuthController{
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public RegisterResponse register(@Valid @RequestBody RegisterRequest request){
        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request){
        return authService.login(request);
    }
}