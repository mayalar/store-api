package com.mayala.store.store_api.service.ProductService;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.mayala.store.store_api.dto.request.AddCartRequest;
import com.mayala.store.store_api.entity.CartItem;

public interface CartService {

    void addToCart(AddCartRequest request, Authentication authentication);

    List<CartItem> getCart(Authentication authentication);

    void deleteItem(Long id);
}