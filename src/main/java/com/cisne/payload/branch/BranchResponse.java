package com.cisne.payload.branch;

import com.cisne.model.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BranchResponse {

    private Long id;

    private String name;

    public BranchResponse(Branch branch) {
        setId(branch.getId());
        setName(branch.getName());
    }
}
