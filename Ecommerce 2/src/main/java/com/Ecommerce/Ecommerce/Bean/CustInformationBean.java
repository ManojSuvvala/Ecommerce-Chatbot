package com.Ecommerce.Ecommerce.Bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "CUSTOMERINFORMATION")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(as = CustInformationBean.class)
@JsonDeserialize(as = CustInformationBean.class)
public class CustInformationBean {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "c_id")
                int cid;
    @Column(name = "FIRST_NAME")
    String fname;
    @Column(name = "LAST_NAME")
        String lname;
    @Column(name = "EMAIL")
    String email;
    @Column(name = "PASSWORD")
    String password;
    @Column(name = "PHONE_NUMBER")
        String phonenumber;
    @Column(name = "ADDRESS")
        String address;
    // add 2 flags
    @Column(name = "IS_USER")
    boolean customer;
    @Column(name = "IS_PRODOWNER")
    boolean prodowner;

}
