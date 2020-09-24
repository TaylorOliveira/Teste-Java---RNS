package com.cisne.controller;

import com.cisne.payload.branch.BranchRequest;
import com.cisne.payload.branch.BranchResponse;
import com.cisne.repository.BranchRepository;
import com.cisne.service.BranchService;
import com.cisne.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class BranchController {

    private final BranchService branchService;
    private final BranchRepository branchRepository;

    @Autowired
    public BranchController(BranchService branchService, BranchRepository branchRepository) {
        this.branchService = branchService;
        this.branchRepository = branchRepository;
    }

    @GetMapping("/branch/{id}")
    public BranchResponse getBranchById(@PathVariable("id") Long id) {
        return branchService.getBranchById(id);
    }

    @PostMapping("/branch")
    public ResponseEntity<?> createBranch(@Valid @RequestBody BranchRequest branchRequest) {
        if(branchRepository.existsByCode(branchRequest.getCode())){
            return Utils.badRequest(false, "Code already registered!");
        }
        branchService.createBranch(branchRequest);
        return Utils.created(true, "Branch successfully created.");
    }

    @PutMapping("/branch")
    public ResponseEntity<?> updateBranch(@Valid @RequestBody BranchRequest branchRequest){
        BranchResponse branchResponse = branchService.updateBranch(branchRequest);
        if(Objects.isNull(branchResponse)){
            return Utils.badRequest(false, "Error update!");
        }
        return Utils.created(true, "Branch updated successfully.");
    }

    @DeleteMapping("/branch/{id}")
    public ResponseEntity<?> deleteBranch(@PathVariable("id") Long id) {
        branchService.deleteBranch(id);
        return Utils.deleted(true, "Branch deleted on success.");
    }

    @GetMapping("/listBranches")
    public List<BranchResponse> getAllAppointments() {
        return branchService.getAllBranches();
    }
}
