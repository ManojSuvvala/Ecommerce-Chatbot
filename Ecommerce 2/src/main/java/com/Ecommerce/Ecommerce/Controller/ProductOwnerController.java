package com.Ecommerce.Ecommerce.Controller;

import com.Ecommerce.Ecommerce.Bean.ProductCategoryBean;
import com.Ecommerce.Ecommerce.Bean.ProductDetailsBean;
import com.Ecommerce.Ecommerce.Bean.ProductOwnerBean;
import com.Ecommerce.Ecommerce.Bean.ProductSubCategory;
import com.Ecommerce.Ecommerce.Service.ProductOwnerService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProductOwnerController {
    @Autowired
    private ProductOwnerService productOwnerService;

    @PostMapping("/ownerregister")
    public ResponseEntity<String> ownerRegister(@RequestBody ProductOwnerBean owner) throws SQLException, ClassNotFoundException {
        System.out.println("Received payload: " + owner);

        String signupResult = productOwnerService.signUpOwner(owner);
        return ResponseEntity.ok().body(signupResult);

    }

    @PostMapping("/addproduct")
    public ResponseEntity<List<ProductDetailsBean>> addProduct(@RequestBody List<ProductDetailsBean> prodlist) throws BadRequestException {
        return ResponseEntity.ok().body(productOwnerService.prodAdd(prodlist));

    }

    @PutMapping("/upadteproduct")
    public ResponseEntity<List<ProductDetailsBean>> updateProduct(@RequestBody List<ProductDetailsBean> updateProdList) throws BadRequestException {
        return ResponseEntity.ok().body(productOwnerService.updateProducts(updateProdList));

    }


@DeleteMapping("/deleteproduct")
    public ResponseEntity<String> delProduct(@RequestBody List<Integer> pdid){
        return  ResponseEntity.ok().body(productOwnerService.deleteProduct(pdid));
}

    @GetMapping("/productcategory")
    public ResponseEntity<List<ProductCategoryBean>> ownerProdCategoryDisplay() throws SQLException, ClassNotFoundException {
        return ResponseEntity.ok().body(productOwnerService.prodCategoryDisplay());
    }

    @GetMapping("/productsubcategory")
    public  ResponseEntity<List<ProductSubCategory>>ownerProdSubCategoryDisplay(){
        return ResponseEntity.ok().body(productOwnerService.prodSubCategoryDisplay());
    }
    @PostMapping("/uploadproductimage")
    public  ResponseEntity<String> uploadProductImage(@RequestParam("file") MultipartFile file, @RequestParam int pdetailsId){
        return ResponseEntity.ok().body(productOwnerService.uploadProdImage(file,pdetailsId));
    }
    @GetMapping("/productDetailsFetch")
    public ResponseEntity<List<ProductDetailsBean>> getProductDetails(@RequestParam int poid) throws BadRequestException {
        List<ProductDetailsBean> productDetails = productOwnerService.getProductDetails(poid);
        if (productDetails != null) {
            return ResponseEntity.ok().body(productDetails);
        } else {
            throw new BadRequestException("Product details not found for PO_ID: " + poid);
        }
    }

    @GetMapping("/getprodownid")
    public ResponseEntity<Integer> getProdOwnerId(String email) throws SQLException{
        return ResponseEntity.ok().body(productOwnerService.getProdOwnId(email));
    }

}
