package com.example.simplewebshopapplication.service;

import com.example.simplewebshopapplication.projection.ProductDto;
import com.example.simplewebshopapplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<ProductDto> findAll() {
        return productRepository.findProductAll();
    }

}
