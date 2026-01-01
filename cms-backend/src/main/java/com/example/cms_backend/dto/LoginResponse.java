package com.example.cms_backend.dto;

import java.util.UUID;

public class LoginResponse{

    private UUID id;
    private String email;

    public LoginResponse(UUID id, String email){
        this.id = id;
        this.email = email;
    }

    public UUID getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }
}