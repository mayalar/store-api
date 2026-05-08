package com.mayala.store.store_api.controller.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayala.store.store_api.dto.request.AddCartRequest;
import com.mayala.store.store_api.service.ProductService.CartService;

@RestController
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(
            @RequestBody AddCartRequest request,
            Authentication authentication) {

        cartService.addToCart(request, authentication);

        return ResponseEntity.ok("Added to cart");
    }

    @GetMapping
    public ResponseEntity<?> getCart(Authentication authentication) {

        return ResponseEntity.ok(
                cartService.getCart(authentication));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {

        cartService.deleteItem(id);

        return ResponseEntity.ok("Item deleted");
    }
}