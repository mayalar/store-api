package com.mayala.store.store_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayala.store.store_api.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}