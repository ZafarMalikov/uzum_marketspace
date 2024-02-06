package com.example.uzumorederservice.order;

import com.example.uzumorederservice.common.service.GenericDtoMapper;
import com.example.uzumorederservice.order.dto.OrderCreateDto;
import com.example.uzumorederservice.order.dto.OrderResponseDto;
import com.example.uzumorederservice.order.entity.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderDtoMapper extends GenericDtoMapper<Order, OrderCreateDto, OrderCreateDto, OrderResponseDto> {

    private final ModelMapper mapper;

    @Override
    public Order toEntity(OrderCreateDto orderCreateDto) {
        return mapper.map(orderCreateDto, Order.class);
    }

    @Override
    public OrderResponseDto toResponseDto(Order order) {
        return mapper.map(order, OrderResponseDto.class);
    }

    @Override
    public void update(OrderCreateDto orderCreateDto, Order order) {
        mapper.map(orderCreateDto, order);
    }
}
