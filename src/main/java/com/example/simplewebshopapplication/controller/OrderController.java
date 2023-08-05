package com.example.simplewebshopapplication.controller;

import com.example.simplewebshopapplication.dto.OrderDto;
import com.example.simplewebshopapplication.dto.CreateOrderDto;
import com.example.simplewebshopapplication.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/create")
    public OrderDto create(@RequestBody CreateOrderDto createOrderDto) {
        return orderService.create(createOrderDto);
    }
}
