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
import java.util.stream.Stream;

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
        if (!seederRun) {
            createSampleBrandsAndProducts();
        }
    }

    private void createSampleBrandsAndProducts() {
        List<BrandEntity> sampleBrands = createSampleBrands();

        List<BrandEntity> brands = brandRepository.saveAll(sampleBrands);

        List<ProductEntity> sampleProducts = createSampleProducts(brands);

        productRepository.saveAll(sampleProducts);
    }

    private List<BrandEntity> createSampleBrands() {
        return IntStream.range(0, 10)
                .mapToObj(this::createBrand)
                .collect(Collectors.toList());
    }

    private BrandEntity createBrand(int index) {
        BrandEntity brand = new BrandEntity();
        brand.setName("Brand" + index);
        return brand;
    }

    private List<ProductEntity> createSampleProducts(List<BrandEntity> brands) {
        return brands.stream()
                .flatMap(brandEntity -> createProductsForBrand(brandEntity))
                .collect(Collectors.toList());
    }

    private Stream<ProductEntity> createProductsForBrand(BrandEntity brandEntity) {
        return IntStream.range(0, 10)
                .mapToObj(brandIndex -> createProduct(brandEntity, brandIndex));
    }

    private ProductEntity createProduct(BrandEntity brandEntity, int index) {
        ProductEntity product = new ProductEntity();
        product.setBrandId(brandEntity.getId());
        product.setPrice(generateRandomPrice());
        product.setName(brandEntity.getName() + " - " + index);
        return product;
    }

    private double generateRandomPrice() {
        double minPrice = 10.0;
        double maxPrice = 200.0;
        return minPrice + Math.random() * (maxPrice - minPrice);
    }
}
