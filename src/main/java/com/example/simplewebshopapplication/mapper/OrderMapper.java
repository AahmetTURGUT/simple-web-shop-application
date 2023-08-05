package com.example.simplewebshopapplication.mapper;


import com.example.simplewebshopapplication.dto.OrderDto;
import com.example.simplewebshopapplication.dto.CreateOrderDto;
import com.example.simplewebshopapplication.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "createOrderDto.price", target = "productValue")
    @Mapping(source = "createOrderDto.fullName", target = "customerName")
    @Mapping(source = "createOrderDto.address", target = "customerAddress")
    @Mapping(source = "createOrderDto.cargoPrice", target = "shippingValue")
    OrderEntity mapToEntity(CreateOrderDto createOrderDto);

    OrderDto mapToDto(OrderEntity orderEntity);

}
