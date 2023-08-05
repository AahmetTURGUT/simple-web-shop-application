package com.example.simplewebshopapplication.projection;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;

    private String name;

    private Double price;

    private String brandName;

    public ProductDto(
            Long id,
            String name,
            Double price,
            String brandName
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brandName = brandName;
    }

}
