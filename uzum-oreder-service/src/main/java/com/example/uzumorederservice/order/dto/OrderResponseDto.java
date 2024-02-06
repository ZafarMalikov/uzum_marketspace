package com.example.uzumorederservice.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponseDto {
    private UUID uuid;
    private String productId;
    private Integer count;
}
