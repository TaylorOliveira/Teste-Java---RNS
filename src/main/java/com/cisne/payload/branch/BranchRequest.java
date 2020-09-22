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

    @NotNull
    @NotBlank(message = "The name cannot be null")
    private String name;
}
