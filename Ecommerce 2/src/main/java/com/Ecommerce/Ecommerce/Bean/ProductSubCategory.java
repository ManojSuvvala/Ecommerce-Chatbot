package com.Ecommerce.Ecommerce.Bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "PRODUCT_SUBCATEGORY")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(as = ProductSubCategory.class)
@JsonDeserialize(as = ProductSubCategory.class)
public class ProductSubCategory {
    @Column(name ="S_PROD_ID")
    @Id
    int S_id;
@Column(name = "SUB_CATEGORY")
    String Subcategory;
//@Column(name = "P_SUBCAT_IMAGE")
//    String image;
}


