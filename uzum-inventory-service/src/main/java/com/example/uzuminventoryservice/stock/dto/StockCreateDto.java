package com.example.uzuminventoryservice.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockCreateDto {

    private String productId;
    private Integer count;
    private LocalDateTime lastSentTime;
    private Integer lastSentCount;
}
