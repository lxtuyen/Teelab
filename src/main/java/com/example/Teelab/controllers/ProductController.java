package com.example.Teelab.controllers;

import com.example.Teelab.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return Collections.emptyList();
    }
    @PostMapping
    public ProductDto createProduct(
            @RequestBody ProductDto product
    ){
        return null;
    }
}
