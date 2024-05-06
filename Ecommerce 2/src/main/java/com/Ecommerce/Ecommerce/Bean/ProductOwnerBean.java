package com.Ecommerce.Ecommerce.Bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "PRODUCTOWNER")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(as = ProductOwnerBean.class)
@JsonDeserialize(as = ProductOwnerBean.class)
public class ProductOwnerBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PO_ID")
    int PO_ID;
    @Column(name = "F_NAME")
    String firstname;
    @Column(name = "L_NAME")
    String lastname;
    @Column(name = "EMAIL")
    String email;
    @Column(name = "PASSWORD")
    String password;
    @Column(name = "COMPANY_NAME")
    String companyname;
    @Column(name = "COMPANY_ADDRESS")
    String companyaddress;
    @Column(name = "PHONE_NUMBER")
    String phonenumber;


}
