package com.example.cms_backend.dto;

import java.util.UUID;

public class LoginResponse{

    private UUID id;
    private String email;
    private String token;

    public LoginResponse(UUID id, String email, String token){
        this.id = id;
        this.email = email;
        this.token = token;
    }

    public UUID getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getToken(){
        return token;
    }
}