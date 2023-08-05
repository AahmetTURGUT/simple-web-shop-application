package com.example.simplewebshopapplication.service.product;

import com.example.simplewebshopapplication.repository.ProductRepository;
import com.example.simplewebshopapplication.service.ProductService;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ProductServiceTestBase {

    @Spy
    @InjectMocks
    protected ProductService productService;

    @Mock
    protected ProductRepository productRepository;

}
