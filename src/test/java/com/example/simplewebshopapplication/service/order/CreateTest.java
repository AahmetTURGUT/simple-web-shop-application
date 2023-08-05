package com.example.simplewebshopapplication.service.order;

import com.example.simplewebshopapplication.dto.OrderDto;
import com.example.simplewebshopapplication.dto.CreateOrderDto;
import com.example.simplewebshopapplication.entity.OrderEntity;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;

public class CreateTest extends OrderTestBase {

    @Test
    public void Should_ReturnOrder() {
        CreateOrderDto createOrderDto = Instancio.create(CreateOrderDto.class);

        OrderEntity orderEntity = Instancio.create(OrderEntity.class);

        OrderDto expected = Instancio.create(OrderDto.class);

        //given
        given(orderRepository.save(any())).willReturn(orderEntity);
        willDoNothing().given(emailService).sendEmailSellProduct(any());
        given(orderMapper.mapToDto(orderEntity)).willReturn(expected);

        //when
        OrderDto actual = orderService.create(createOrderDto);

        assertEquals(expected, actual);

    }
}
