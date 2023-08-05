package com.example.simplewebshopapplication.dto;

import lombok.Data;

@Data
public class CreateOrderDto {

    private Long productId;

    private Double price;

    private String fullName;

    private String address;

    private Double cargoPrice;
}
