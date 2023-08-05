package com.example.simplewebshopapplication.service.order;

import com.example.simplewebshopapplication.mapper.OrderMapper;
import com.example.simplewebshopapplication.mapper.OrderMapperImpl;
import com.example.simplewebshopapplication.repository.OrderRepository;
import com.example.simplewebshopapplication.service.EmailService;
import com.example.simplewebshopapplication.service.OrderService;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class OrderTestBase  {
    @Spy
    @InjectMocks
    protected OrderService orderService;

    @Mock
    protected EmailService emailService;

    @Mock
    protected OrderRepository orderRepository;

    @Spy
    protected OrderMapper orderMapper = new OrderMapperImpl();
}
