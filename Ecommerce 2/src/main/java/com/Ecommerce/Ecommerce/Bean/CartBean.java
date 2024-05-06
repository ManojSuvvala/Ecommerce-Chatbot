package com.Ecommerce.Ecommerce.Bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
@Table(name = "CART")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonSerialize(as = CartBean.class)
@JsonDeserialize(as = CartBean.class)
public class CartBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID")
    int cartId;
    //@Column(name = "CART_PRODUCTDETAILS_ID")
    @Column(name = "CART_PRODUCTDETAILS_ID")
    int cartPdetailsId;

    @Column(name = "CART_CUSTOMER_ID")
    int cartCustId;
    @Column(name = "QUANTITY")
    int quantity;


}
