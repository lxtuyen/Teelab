package com.example.Teelab.services;

import com.example.Teelab.dto.ProductDto;
import com.example.Teelab.entities.Product;
import com.example.Teelab.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService  {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(ProductDto product) {

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }
    private Product createProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setBrand(productDto.getBrand());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setNewArrival(productDto.isNewArrival());

        return product;
    }
}
