package com.example.uzumorederservice.stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockResponseDto {
    private UUID id;
    private String productId;
    private Integer count;
    private LocalDateTime lastSentTime;
    private Integer lastSentCount;
}
