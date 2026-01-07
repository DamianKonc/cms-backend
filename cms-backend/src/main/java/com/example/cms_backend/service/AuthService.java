package com.example.cms_backend.service;

import com.example.cms_backend.dto.RegisterRequest;
import com.example.cms_backend.dto.RegisterResponse;
import com.example.cms_backend.dto.LoginRequest;
import com.example.cms_backend.dto.LoginResponse;

import com.example.cms_backend.model.User;
import com.example.cms_backend.repository.UserRepository;
import com.example.cms_backend.exception.EmailAlreadyExistsException;
import com.example.cms_backend.exception.InvalidCredentialsException;
import com.example.cms_backend.security.JwtService;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class AuthService{
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
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
            .orElseThrow(InvalidCredentialsException::new);

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        throw new InvalidCredentialsException();
    }

    String token = jwtService.generateToken(
        user.getId().toString(),
        user.getEmail()
    );

    return new LoginResponse(
        user.getId(),
        user.getEmail(),
        token
    );
}

}