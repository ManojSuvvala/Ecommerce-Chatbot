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
    @OneToOne
    //@Column(name = "CART_PRODUCTDETAILS_ID")
    @JoinColumn(name = "CART_PRODUCTDETAILS_ID")
     ProductDetailsBean cartPdetailsId;
    @OneToOne
    @JoinColumn(name = "CART_CUSTOMER_ID")
     CustInformationBean cartCustId;
    @Column(name = "QUANTITY")
    int quantity;


}
