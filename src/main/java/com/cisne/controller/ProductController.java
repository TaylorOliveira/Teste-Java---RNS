package com.cisne.controller;

import com.cisne.payload.product.ProductRequest;
import com.cisne.payload.product.ProductResponse;
import com.cisne.repository.ProductRepository;
import com.cisne.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/product/{id}")
    public ProductResponse getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@Validated @RequestBody ProductRequest productRequest) {
        if(productRepository.existsByCode(productRequest.getCode())){
            return ResponseEntity.badRequest().body("Code already registered");
        }
        return ResponseEntity.ok().body(productService.createProduct(productRequest));
    }

    @PutMapping("/product")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.updateProduct(productRequest);
        if(Objects.isNull(productResponse)){
            return ResponseEntity.badRequest().body("Error update");
        }
        return ResponseEntity.ok().body(productResponse);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().body("Deleted on success");
    }

    @GetMapping("/listProducts")
    public List<ProductResponse> getAllBranchProducts() {
        return productService.getAllProducts();
    }
}
