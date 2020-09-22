package com.cisne.payload.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequest {

    private String name;

    private Long stockQuantity;
}
