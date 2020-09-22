package com.cisne.controller;

import com.cisne.payload.branch.BranchRequest;
import com.cisne.payload.branch.BranchResponse;
import com.cisne.repository.BranchRepository;
import com.cisne.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<?> createBranch(@Validated @RequestBody BranchRequest branchRequest) {
        if(branchRepository.existsByCode(branchRequest.getCode())){
            return ResponseEntity.badRequest().body("Code already registered");
        }
        BranchResponse branchResponse = branchService.createBranch(branchRequest);
        return ResponseEntity.ok().body(branchResponse);
    }

    @PutMapping("/branch")
    public ResponseEntity<?> updateBranch(@Valid @RequestBody BranchRequest branchRequest){
        BranchResponse branchResponse = branchService.updateBranch(branchRequest);
        if(Objects.isNull(branchResponse)){
            return ResponseEntity.badRequest().body("Error update");
        }
        return ResponseEntity.ok().body(branchResponse);
    }

    @DeleteMapping("/branch/{id}")
    public ResponseEntity<?> deleteBranch(@PathVariable("id") Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.ok().body("Deleted on success");
    }

    @GetMapping("/listBranches")
    public List<BranchResponse> getAllAppointments() {
        return branchService.getAllBranches();
    }
}
