package com.example.uzumproductservice.product;

import com.example.uzumproductservice.product.dto.ProductCreateDto;
import com.example.uzumproductservice.product.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductCreateDto productCreateDto) {

        ProductResponseDto productResponseDto = service.create(productCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable String id) {
        ProductResponseDto productResponseDto = service.getId(id);
        return ResponseEntity.ok(productResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDto>> getAll(Pageable pageable) {
        Page<ProductResponseDto> productResponseDto = service.getAll(pageable);
        return ResponseEntity.ok(productResponseDto);
    }


}
