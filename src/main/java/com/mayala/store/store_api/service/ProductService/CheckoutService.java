package com.mayala.store.store_api.service.ProductService;

import org.springframework.security.core.Authentication;

import com.mayala.store.store_api.entity.Order;

public interface CheckoutService {

    Order checkout(Authentication authentication);
}