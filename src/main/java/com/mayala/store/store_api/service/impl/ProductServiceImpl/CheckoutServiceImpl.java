package com.mayala.store.store_api.service.impl.ProductServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mayala.store.store_api.entity.CartItem;
import com.mayala.store.store_api.entity.Order;
import com.mayala.store.store_api.entity.User;
import com.mayala.store.store_api.repository.CartItemRepository;
import com.mayala.store.store_api.repository.OrderRepository;
import com.mayala.store.store_api.repository.UserRepository;
import com.mayala.store.store_api.service.ProductService.CheckoutService;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Order checkout(Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow();

        List<CartItem> items = cartItemRepository.findByUser(user);

        double total = items.stream()
                .mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity())
                .sum();

        Order order = new Order();

        order.setUser(user);
        order.setTotal(total);
        order.setCreatedAt(LocalDateTime.now());

        orderRepository.save(order);
        cartItemRepository.deleteAll(items);
        return order;
    }
}