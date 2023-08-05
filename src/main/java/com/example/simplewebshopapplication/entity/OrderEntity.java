package com.example.simplewebshopapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "`order`")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "product_value", nullable = false)
    private Double productValue;


    @Column(name = "shipping_value", nullable = false)
    private Double shippingValue;


    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_address", nullable = false)
    private String customerAddress;



    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", productValue=" + productValue +
                ", shippingValue=" + shippingValue +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }

}
