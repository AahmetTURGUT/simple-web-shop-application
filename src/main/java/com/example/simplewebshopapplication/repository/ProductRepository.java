package com.example.simplewebshopapplication.repository;

import com.example.simplewebshopapplication.projection.ProductDto;
import com.example.simplewebshopapplication.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("select new com.example.simplewebshopapplication.projection.ProductDto(p.id, p.name, p.price, b.name) from ProductEntity p " +
            "left join BrandEntity b on p.brandId = b.id")
    List<ProductDto> findProductAll();
}
