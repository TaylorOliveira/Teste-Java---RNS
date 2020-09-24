package com.cisne.controller;

import com.cisne.payload.product.ProductRequest;
import com.cisne.payload.product.ProductResponse;
import com.cisne.repository.ProductRepository;
import com.cisne.service.ProductService;
import com.cisne.util.Utils;
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
            return Utils.badRequest(false, "Code already registered!");
        }
        productService.createProduct(productRequest);
        return Utils.created(true, "Product successfully created.");
    }

    @PutMapping("/product")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.updateProduct(productRequest);
        if(Objects.isNull(productResponse)){
            return Utils.badRequest(false, "Error update!");
        }
        return Utils.created(true, "Product successfully created.");
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return Utils.deleted(true, "Product deleted on success.");
    }

    @GetMapping("/listProducts")
    public List<ProductResponse> getAllBranchProducts() {
        return productService.getAllProducts();
    }
}
