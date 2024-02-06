package com.example.uzuminventoryservice.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "uzum-product-service")
public interface ProductFeignClient {
    @GetMapping("/api/v1/product/{id}")
    ResponseEntity<ProductResponseDto> getProduct(@PathVariable String id);
}

