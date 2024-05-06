package com.Ecommerce.Ecommerce.Bean;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "PRODUCT_CATEGORY")
@Entity
@Data
public class ProductCategoryBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="PRODUCT_ID")
    int Product_id;

    @Column(name ="CATEGORY")
    String Category;

    public int getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(int product_id) {
        Product_id = product_id;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
