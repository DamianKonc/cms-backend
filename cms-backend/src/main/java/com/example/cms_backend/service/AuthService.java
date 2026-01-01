package com.example.cms_backend.service;

import com.example.cms_backend.dto.RegisterRequest;
import com.example.cms_backend.dto.RegisterResponse;
import com.example.cms_backend.dto.LoginRequest;
import com.example.cms_backend.dto.LoginResponse;

import com.example.cms_backend.model.User;
import com.example.cms_backend.repository.UserRepository;
import com.example.cms_backend.exception.EmailAlreadyExistsException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class AuthService{
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse register(RegisterRequest request){

        if(userRepository.existsByEmail(request.getEmail())){
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);
        return new RegisterResponse(
            savedUser.getId(),
            savedUser.getEmail()
        );
    }

    public LoginResponse login(LoginRequest request){
        
        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid email or password");
        }

        return new LoginResponse(
            user.getId(),
            user.getEmail()
        );
    }
}