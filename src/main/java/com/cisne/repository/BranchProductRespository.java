package com.cisne.repository;

import com.cisne.model.Branch;
import com.cisne.model.BranchProduct;
import com.cisne.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BranchProductRespository extends JpaRepository<BranchProduct, Long>  {

    BranchProduct findBranchProductByBranchAndProduct(Branch branch, Product product);
}
