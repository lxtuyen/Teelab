package com.example.Teelab.controllers;

import com.example.Teelab.dto.ProductDto;
import com.example.Teelab.entities.Product;
import com.example.Teelab.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(
            @RequestBody ProductDto productDto
    ){
        Product product = productService.addProduct(productDto);
        return null;
    }
}
