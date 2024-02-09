package com.Ecommerce.Ecommerce.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "PRODUCT_SUBCATEGORY")
@Entity
@Data

public class ProductSubCategory {
    @Column(name ="S_PROD_ID")
    @Id
    int S_id;
@Column(name = "SUB_CATEGORY")
    String Subcategory;
@Column(name = "P_SUBCAT_IMAGE")
    String image;
}


