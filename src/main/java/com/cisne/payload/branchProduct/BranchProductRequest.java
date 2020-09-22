package com.cisne.payload.branchProduct;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BranchProductRequest {

    private Long quantity;

    private Long branchId;

    private Long productId;
}
