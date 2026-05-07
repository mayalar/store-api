package com.mayala.store.store_api.service.AuthService;


import com.mayala.store.store_api.dto.request.LoginRequest;
import com.mayala.store.store_api.dto.request.RegisterRequest;
import com.mayala.store.store_api.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}