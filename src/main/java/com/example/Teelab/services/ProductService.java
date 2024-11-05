package com.example.Teelab.services;

import com.example.Teelab.dto.ProductDto;
import com.example.Teelab.entities.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(ProductDto product);
    public List<Product> getAllProducts();

}
