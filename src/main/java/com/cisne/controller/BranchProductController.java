package com.cisne.controller;

import com.cisne.payload.branchProduct.BranchProductRequest;
import com.cisne.payload.branchProduct.BranchProductResponse;
import com.cisne.service.BranchProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class BranchProductController {

    private final BranchProductService branchProductService;

    @Autowired
    public BranchProductController(BranchProductService branchProductService) {
        this.branchProductService = branchProductService;
    }

    @PostMapping("/branchProduct")
    public ResponseEntity<?> createBranchProduct(@Validated @RequestBody BranchProductRequest branchProductRequest) {
        BranchProductResponse branchProductResponse = branchProductService.createBranchProduct(branchProductRequest);
        if(Objects.isNull(branchProductResponse)){
            return ResponseEntity.badRequest().body("Error saving");
        }
        return ResponseEntity.ok().body(branchProductResponse);
    }

    @DeleteMapping("/branchProduct/{id}")
    public ResponseEntity<?> deleteBranchProduct(@PathVariable("id") Long id) {
        branchProductService.deleteBranchProduct(id);
        return ResponseEntity.ok().body("Deleted on success");
    }

    @GetMapping("/listBranchProducts")
    public List<BranchProductResponse> getAllBranchProducts() {
        return branchProductService.getAllBranchProducts();
    }
}
