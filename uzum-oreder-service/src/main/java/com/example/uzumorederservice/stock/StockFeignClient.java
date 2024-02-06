package com.example.uzumorederservice.stock;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "uzum-inventory-service")
public interface StockFeignClient {
    @GetMapping("/api/v1/stock/{id}")
    ResponseEntity<StockResponseDto> getProduct(@PathVariable String id);

    @PostMapping("/api/v1/stock/update")
    ResponseEntity<String> updateStock(@RequestBody StockUpdateDto request);
}
