package com.cisne.payload.branchProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchProductRequest {

    private Long id;

    @NotNull
    @NotBlank
    private Long quantity;

    @NotNull
    @NotBlank
    private Long branchId;

    @NotNull
    @NotBlank
    private Long productId;

    @NotNull
    @NotBlank
    private Date transferDate;
}
