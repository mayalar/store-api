package com.mayala.store.store_api.service.impl.AuthServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mayala.store.store_api.dto.request.LoginRequest;
import com.mayala.store.store_api.dto.request.RegisterRequest;
import com.mayala.store.store_api.dto.response.AuthResponse;
import com.mayala.store.store_api.entity.User;
import com.mayala.store.store_api.repository.UserRepository;
import com.mayala.store.store_api.security.JwtService;
import com.mayala.store.store_api.service.AuthService.AuthService;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  JwtService jwtService;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(RegisterRequest request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponse(token);
    }
}