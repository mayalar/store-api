package com.mayala.store.store_api.service.AuthService;

import org.springframework.security.core.Authentication;

import com.mayala.store.store_api.dto.request.LoginRequest;
import com.mayala.store.store_api.dto.request.RegisterRequest;
import com.mayala.store.store_api.dto.response.AuthResponse;
import com.mayala.store.store_api.dto.response.UserProfileResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    UserProfileResponse getProfile(Authentication authentication);
}