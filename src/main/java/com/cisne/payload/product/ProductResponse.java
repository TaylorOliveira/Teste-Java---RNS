package com.cisne.payload.product;

import com.cisne.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {

    private Long id;

    private String name;

    private String code;

    private Long stockQuantity;

    public ProductResponse(Product product) {
        setId(product.getId());
        setName(product.getName());
        setCode(product.getCode());
        setStockQuantity(product.getStockQuantity());
    }
}
