package com.Ecommerce.Ecommerce.Bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table(name = "PRODUCTOWNER")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@JsonSerialize(as = ProductOwnerBean.class)
@JsonDeserialize(as = ProductOwnerBean.class)
public class ProductOwnerBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PO_ID")
    int PO_ID;
    @Column(name = "F_NAME")
    String F_NAME;
    @Column(name = "L_NAME")
    String L_NAME;
    @Column(name = "EMAIL")
    String EMAIL;
    @Column(name = "PASSWORD")
    String PASSWORD;
    @Column(name = "COMPANY_NAME")
    String COMPANY_NAME;
    @Column(name = "COMPANY_ADDRESS")
    String COMPANY_ADDRESS;
    @Column(name = "PHONE_NUMBER")
    String PHONE_NUMBER;

//    public ProductOwnerBean(int PO_ID, String f_NAME, String l_NAME, String EMAIL, String PASSWORD, String COMPANY_NAME, String COMPANY_ADDRESS, String PHONE_NUMBER) {
//        this.PO_ID = PO_ID;
//        this.F_NAME = f_NAME;
//        this.L_NAME = l_NAME;
//        this.EMAIL = EMAIL;
//        this.PASSWORD = PASSWORD;
//        this.COMPANY_NAME = COMPANY_NAME;
//        this.COMPANY_ADDRESS = COMPANY_ADDRESS;
//        this.PHONE_NUMBER = PHONE_NUMBER;
//    }
//
//    public ProductOwnerBean() {
//    }
//
//    public int getPO_ID() {
//        return PO_ID;
//    }
//
//    public void setPO_ID(int PO_ID) {
//        this.PO_ID = PO_ID;
//    }
//
//    public String getF_NAME() {
//        return F_NAME;
//    }
//
//    public void setF_NAME(String f_NAME) {
//        F_NAME = f_NAME;
//    }
//
//    public String getL_NAME() {
//        return L_NAME;
//    }
//
//        public void setL_NAME(String l_NAME) {
//        L_NAME = l_NAME;
//    }
//
//    public String getEMAIL() {
//        return EMAIL;
//    }
//
//        public void setEMAIL(String EMAIL) {
//        this.EMAIL = EMAIL;
//    }
//
//    public String getPASSWORD() {
//        return PASSWORD;
//    }
//
//    public void setPASSWORD(String PASSWORD) {
//        this.PASSWORD = PASSWORD;
//    }
//
//    public String getCOMPANY_NAME() {
//        return COMPANY_NAME;
//    }
//
//    public void setCOMPANY_NAME(String COMPANY_NAME) {
//        this.COMPANY_NAME = COMPANY_NAME;
//    }
//
//    public String getCOMPANY_ADDRESS() {
//        return COMPANY_ADDRESS;
//    }
//
//    public void setCOMPANY_ADDRESS(String COMPANY_ADDRESS) {
//        this.COMPANY_ADDRESS = COMPANY_ADDRESS;
//    }
//
//    public String getPHONE_NUMBER() {
//        return PHONE_NUMBER;
//    }
//
//    public void setPHONE_NUMBER(String PHONE_NUMBER) {
//        this.PHONE_NUMBER = PHONE_NUMBER;
//    }
}
