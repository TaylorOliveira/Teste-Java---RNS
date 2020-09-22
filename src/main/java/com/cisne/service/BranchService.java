package com.cisne.service;

import com.cisne.model.Branch;
import com.cisne.payload.branch.BranchRequest;
import com.cisne.payload.branch.BranchResponse;
import com.cisne.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchService {

    private final BranchRepository branchRepository;

    @Autowired
    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public BranchResponse createBranch(BranchRequest branchRequest){
        Branch branch = new Branch();
        branch.setName(branchRequest.getName());
        branchRepository.save(branch);
        return new BranchResponse(branch);
    }

    public List<BranchResponse> getAllBranches(){
        List<Branch> listBranches = branchRepository.findAll();
        List<BranchResponse> listBranchesResponse = new ArrayList<>();
        for(Branch branch : listBranches){
            listBranchesResponse.add(new BranchResponse(branch.getId(), branch.getName()));
        }
        return listBranchesResponse;
    }
}
