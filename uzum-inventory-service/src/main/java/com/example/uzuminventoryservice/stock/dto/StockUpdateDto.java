package com.example.uzuminventoryservice.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockUpdateDto {

    private String productId;
    private Integer count;

}
