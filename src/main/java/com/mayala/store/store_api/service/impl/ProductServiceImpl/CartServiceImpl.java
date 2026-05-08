package com.mayala.store.store_api.service.impl.ProductServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mayala.store.store_api.dto.request.AddCartRequest;
import com.mayala.store.store_api.entity.CartItem;
import com.mayala.store.store_api.entity.Product;
import com.mayala.store.store_api.entity.User;
import com.mayala.store.store_api.repository.CartItemRepository;
import com.mayala.store.store_api.repository.ProductRepository;
import com.mayala.store.store_api.repository.UserRepository;
import com.mayala.store.store_api.service.ProductService.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addToCart(AddCartRequest request, Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow();

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow();

        CartItem item = new CartItem();

        item.setUser(user);
        item.setProduct(product);
        item.setQuantity(request.getQuantity());

        cartItemRepository.save(item);
    }

    @Override
    public List<CartItem> getCart(Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow();

        return cartItemRepository.findByUser(user);
    }

    @Override
    public void deleteItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}