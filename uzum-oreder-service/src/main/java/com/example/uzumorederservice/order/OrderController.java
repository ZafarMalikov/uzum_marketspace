package com.example.uzumorederservice.order;

import com.example.uzumorederservice.order.dto.OrderCreateDto;
import com.example.uzumorederservice.order.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public ResponseEntity<OrderResponseDto> create(@RequestBody OrderCreateDto createDto) {
        OrderResponseDto orderResponseDto = service.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDto);
    }
}
