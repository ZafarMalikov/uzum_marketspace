package com.example.uzumproductservice.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Product {

    private String id;
    private String name;
    private BigInteger price;
    private String color;
    private String category;

}
