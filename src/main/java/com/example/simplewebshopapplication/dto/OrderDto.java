package com.example.simplewebshopapplication.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Long id;

    private Double productValue;

    private Double shippingValue;

    private String customerName;

    private String customerAddress;
}
