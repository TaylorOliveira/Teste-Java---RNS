package com.cisne.payload.branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchRequest {

    private Long id;

    @NotNull
    @NotBlank
    private String code;

    @NotNull
    @NotBlank
    private String name;
}
