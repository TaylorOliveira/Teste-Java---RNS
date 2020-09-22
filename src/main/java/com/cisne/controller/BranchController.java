package com.cisne.controller;

import com.cisne.payload.branch.BranchRequest;
import com.cisne.payload.branch.BranchResponse;
import com.cisne.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BranchController {

    private final BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping("/branch")
    public ResponseEntity<?> createBranch(@Validated @RequestBody BranchRequest branchRequest) {
        BranchResponse branchResponse = branchService.createBranch(branchRequest);
        return ResponseEntity.ok().body(branchResponse);
    }

    @GetMapping("/listBranches")
    public List<BranchResponse> getAllAppointments() {
        return branchService.getAllBranches();
    }
}
