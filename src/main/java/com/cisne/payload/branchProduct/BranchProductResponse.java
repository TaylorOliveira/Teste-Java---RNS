package com.cisne.payload.branchProduct;

import com.cisne.model.BranchProduct;
import com.cisne.payload.branch.BranchResponse;
import com.cisne.payload.product.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BranchProductResponse {

    private Long id;

    private Long quantity;

    private BranchResponse branch;

    private ProductResponse product;

    public BranchProductResponse(BranchProduct branchProduct) {
        setId(branchProduct.getId());
        setBranch(new BranchResponse(branchProduct.getBranch()));
        setProduct(new ProductResponse(branchProduct.getProduct()));
        setQuantity(branchProduct.getQuantity());
    }
}
