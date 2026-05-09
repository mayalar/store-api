package com.mayala.store.store_api.service.impl.ProductServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mayala.store.store_api.dto.response.OrderResponse;
import com.mayala.store.store_api.entity.Order;
import com.mayala.store.store_api.entity.User;
import com.mayala.store.store_api.repository.OrderRepository;
import com.mayala.store.store_api.repository.UserRepository;
import com.mayala.store.store_api.service.ProductService.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<OrderResponse> getOrders(
            Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository
                .findByEmail(email)
                .orElseThrow();

        return orderRepository.findByUser(user)
                .stream()
                .map(order -> {
                    OrderResponse response = new OrderResponse();
                    response.setId(order.getId());
                    response.setTotal(order.getTotal());
                    response.setCreatedAt(order.getCreatedAt());
                    return response;
                })
                .toList();
    }
}
