package com.QBproducts.QuickBuy_Products.controllers;

import com.QBproducts.QuickBuy_Products.DTOs.UpdateRequestDTO;
import com.QBproducts.QuickBuy_Products.Entities.Product;
import com.QBproducts.QuickBuy_Products.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveProduct(product));
    }

    @PutMapping("{productId}")
    public ResponseEntity<Product> updateProductDetails(@RequestParam int productId, @RequestBody UpdateRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateProduct(productId,requestDTO));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getProductData(productId));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllProducts());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer productId){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteProductById(productId));
    }


}
