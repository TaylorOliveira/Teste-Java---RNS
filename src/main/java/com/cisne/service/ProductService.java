package com.cisne.service;

import com.cisne.model.Branch;
import com.cisne.model.Product;
import com.cisne.payload.branch.BranchRequest;
import com.cisne.payload.branch.BranchResponse;
import com.cisne.payload.product.ProductRequest;
import com.cisne.payload.product.ProductResponse;
import com.cisne.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse getProductById(Long id){
        Product product = productRepository.getOne(id);
        return new ProductResponse(product);
    }

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setStockQuantity(productRequest.getStockQuantity());
        productRepository.save(product);
        return new ProductResponse(product);
    }

    public ProductResponse updateProduct(ProductRequest productRequest){
        if(Objects.isNull(productRequest.getId())){
            return null;
        }

        Product product = productRepository.getOne(productRequest.getId());
        product.setCode(productRequest.getCode());
        product.setName(productRequest.getName());
        product.setStockQuantity(productRequest.getStockQuantity());
        productRepository.save(product);
        return new ProductResponse(product);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.getOne(id);
        productRepository.delete(product);
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> listProducts = productRepository.findAll();
        List<ProductResponse> listProductsResponse = new ArrayList<>();
        for(Product product :  listProducts){
            listProductsResponse.add(new ProductResponse(product.getId(), product.getName(),
                    product.getCode(), product.getStockQuantity()));
        }
        return listProductsResponse;
    }
}
