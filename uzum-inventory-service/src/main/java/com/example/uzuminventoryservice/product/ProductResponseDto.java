package com.example.uzuminventoryservice.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {
    private String id;
    private String name;
    private BigInteger price;
    private String color;
    private String category;
}
