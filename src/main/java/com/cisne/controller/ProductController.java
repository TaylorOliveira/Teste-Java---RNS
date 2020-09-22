package com.cisne.controller;

import com.cisne.payload.product.ProductRequest;
import com.cisne.payload.product.ProductResponse;
import com.cisne.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@Validated @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.createProduct(productRequest);
        return ResponseEntity.ok().body(productResponse);
    }

    @GetMapping("/listProducts")
    public List<ProductResponse> getAllBranchProducts() {
        return productService.getAllProducts();
    }
}
