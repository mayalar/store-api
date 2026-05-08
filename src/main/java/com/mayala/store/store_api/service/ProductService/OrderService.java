package com.mayala.store.store_api.service.ProductService;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.mayala.store.store_api.dto.response.OrderResponse;

public interface OrderService {
    List<OrderResponse> getOrders(Authentication authentication);
}
