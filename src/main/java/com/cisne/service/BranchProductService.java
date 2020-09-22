package com.cisne.service;

import com.cisne.model.BranchProduct;
import com.cisne.model.Product;
import com.cisne.payload.branchProduct.BranchProductRequest;
import com.cisne.payload.branchProduct.BranchProductResponse;
import com.cisne.repository.BranchProductRespository;
import com.cisne.repository.BranchRepository;
import com.cisne.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BranchProductService {

    private final BranchProductRespository branchProductRespository;
    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;

    @Autowired
    public BranchProductService(BranchProductRespository branchProductRespository,
                                ProductRepository productRepository,
                                BranchRepository branchRepository) {
        this.branchProductRespository = branchProductRespository;
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
    }

    public BranchProductResponse createBranchProduct(BranchProductRequest branchProductRequest){
        BranchProduct branchProduct = new BranchProduct();

        if(Objects.nonNull(branchProductRequest.getBranchId())){
            branchProduct.setBranch(branchRepository.getOne(branchProductRequest.getBranchId()));
        }

        if(Objects.nonNull(branchProductRequest.getProductId())){
            Product product = productRepository.getOne(branchProductRequest.getProductId());
            if(branchProductRequest.getQuantity() <= product.getStockQuantity()){
                branchProduct.setQuantity(branchProductRequest.getQuantity());
                branchProduct.setProduct(product);

                product.setStockQuantity(
                        product.getStockQuantity() - branchProductRequest.getQuantity()
                );
                productRepository.save(product);
            }
        }

        branchProductRespository.save(branchProduct);
        return new BranchProductResponse(branchProduct);
    }

    public List<BranchProductResponse> getAllBranchProducts(){
        List<BranchProduct> listBranchesProducts = branchProductRespository.findAll();
        List<BranchProductResponse> listBranchesProductsResponse = new ArrayList<>();

        for(BranchProduct branchProduct : listBranchesProducts){
            listBranchesProductsResponse.add(new BranchProductResponse(branchProduct));
        }
        return listBranchesProductsResponse;
    }
}
