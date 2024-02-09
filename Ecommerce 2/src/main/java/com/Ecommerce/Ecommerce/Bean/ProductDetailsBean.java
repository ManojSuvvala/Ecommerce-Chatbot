package com.Ecommerce.Ecommerce.Bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "PRODUCTDETAILS")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonSerialize(as = ProductDetailsBean.class)
@JsonDeserialize(as = ProductDetailsBean.class)
public class ProductDetailsBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCTDETAILS_ID")
    int pDetailsId;
    @Column(name = "PRODUCT_NAME")

    String productName;
    @Column(name = "PRODUCT_PRICE")
    int productPrice;
    @Column(name = "DESCRIPTION")

    String description;
    @Column(name = "PRODUCT_IMAGE")
    String productImage;
    @Column(name = "PRODUCTCATEGORY_ID")
int productCategoryId;
    @Column(name = "PRODUCT_SUBCATEGORY_ID")
int productSubCategoryId;
    @Column(name = "PO_ID")
    int poID;
}
