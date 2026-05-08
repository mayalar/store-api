package com.mayala.store.store_api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCartRequest {

    private Long productId;
    private Integer quantity;
}