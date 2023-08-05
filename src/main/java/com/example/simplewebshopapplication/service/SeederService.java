package com.example.simplewebshopapplication.service;

import com.example.simplewebshopapplication.entity.BrandEntity;
import com.example.simplewebshopapplication.entity.ProductEntity;
import com.example.simplewebshopapplication.repository.BrandRepository;
import com.example.simplewebshopapplication.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class SeederService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    @Value("${seeder.run}")
    private Boolean seederRun;

    @PostConstruct
    @Transactional
    public void seedDatabase() {
        if (seederRun) {
            createSampleBrandsAndProducts();
        }
    }


    private void createSampleBrandsAndProducts() {
        List<BrandEntity> sampleBrands = IntStream.range(0, 10)
                .mapToObj(i -> {
                    BrandEntity brand = new BrandEntity();
                    brand.setName("Brand" + i);
                    return brand;
                })
                .collect(Collectors.toList());

        List<BrandEntity> brands = brandRepository.saveAll(sampleBrands);


        List<ProductEntity> sampleProducts = brands.stream()
                .flatMap(brandEntity -> IntStream.range(0, 10)
                        .mapToObj(brandIndex -> {
                            ProductEntity product = new ProductEntity();
                            product.setBrandId(brandEntity.getId());
                            product.setPrice(0 + 100 * Math.random());
                            product.setName(brandEntity.getName() + " - " + brandIndex);
                            return product;
                        }))
                .collect(Collectors.toList());

        productRepository.saveAll(sampleProducts);
    }

}
