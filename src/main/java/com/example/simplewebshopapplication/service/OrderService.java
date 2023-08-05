package com.example.simplewebshopapplication.service;

import com.example.simplewebshopapplication.dto.OrderDto;
import com.example.simplewebshopapplication.dto.CreateOrderDto;
import com.example.simplewebshopapplication.entity.OrderEntity;
import com.example.simplewebshopapplication.mapper.OrderMapper;
import com.example.simplewebshopapplication.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final EmailService emailService;

    public OrderDto create(CreateOrderDto createOrderDto) {
        OrderEntity createdOrder = orderRepository.save(orderMapper.mapToEntity(createOrderDto));
        sendNotificationByOrder(createdOrder.toString());

        return orderMapper.mapToDto(createdOrder);
    }

    private void sendNotificationByOrder(String message) {
        emailService.sendEmailSellProduct(message);
    }

}
