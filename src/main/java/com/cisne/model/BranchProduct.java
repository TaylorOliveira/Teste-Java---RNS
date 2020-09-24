package com.cisne.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.util.Date;

@Entity
@Table(name = "TB_BRANCH_PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BRANCH_ID")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "TRANSFER_DATE")
    private Date transferDate;
}
