package com.Ecommerce.Ecommerce.Controller;

import com.Ecommerce.Ecommerce.Bean.CartBean;
import com.Ecommerce.Ecommerce.Service.CustomerCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CustomerCartService customerCartService;
    @GetMapping("/getcart")
    public ResponseEntity<List<CartBean>> custCart(@RequestParam int custid) throws SQLException, ClassNotFoundException {
        return ResponseEntity.ok().body(customerCartService.getCart(custid));
    }
    @PostMapping("/savecart")
    public  ResponseEntity<List<CartBean>> saveCustCart(@RequestBody CartBean cartBean){
        return ResponseEntity.ok().body(customerCartService.saveCart(cartBean));
    }

    @DeleteMapping("/deletecart")
    public void  deleteCart(@RequestParam int cartId){
        customerCartService.deleteCart(cartId);
    }
    @PutMapping("/updatecart")
    public void updateCart(@RequestParam int cartId, int quantity) throws Exception {
        customerCartService.updateCart(cartId,quantity);
    }
}
