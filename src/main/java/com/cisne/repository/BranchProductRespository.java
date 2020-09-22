package com.cisne.repository;

import com.cisne.model.BranchProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchProductRespository extends JpaRepository<BranchProduct, Long>  {
}
