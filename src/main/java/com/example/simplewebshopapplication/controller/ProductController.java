package com.example.simplewebshopapplication.controller;

import com.example.simplewebshopapplication.projection.ProductDto;
import com.example.simplewebshopapplication.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping(value = "/list")
    public List<ProductDto> findAll() {
        return productService.findAll();
    }
}
