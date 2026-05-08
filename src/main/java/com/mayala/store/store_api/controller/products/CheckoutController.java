package com.mayala.store.store_api.controller.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayala.store.store_api.service.ProductService.CheckoutService;

@RestController
@RequestMapping("/orders")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(Authentication authentication) {

        return ResponseEntity.ok(
                checkoutService.checkout(authentication)
        );
    }
}