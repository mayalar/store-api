package com.mayala.store.store_api.controller.products;

import com.mayala.store.store_api.dto.response.OrderResponse;
import com.mayala.store.store_api.service.ProductService.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrders(
            Authentication authentication) {

        return ResponseEntity.ok(
                orderService.getOrders(authentication));
    }
}