package com.mayala.store.store_api.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private Double total;
    private LocalDateTime createdAt;

}
