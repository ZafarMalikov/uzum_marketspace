package com.example.uzuminventoryservice.stock;

import com.example.uzuminventoryservice.stock.dto.StockCreateDto;
import com.example.uzuminventoryservice.stock.dto.StockResponseDto;
import com.example.uzuminventoryservice.stock.dto.StockUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService service;

    @PostMapping
    public ResponseEntity<StockResponseDto> create(@RequestBody StockCreateDto createDto) {

        StockResponseDto stockResponseDto = service.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(stockResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<StockResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<StockResponseDto> all = service.getAll(pageable, predicate);
        return ResponseEntity.ok(all);

    }

    @GetMapping("/{id}")
    public ResponseEntity<StockResponseDto> getId(@PathVariable String id) {
        StockResponseDto all = service.getProductId(id);
        return ResponseEntity.ok(all);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateStock(@RequestBody StockUpdateDto request) {
        service.updateStock(request.getProductId(), request.getCount());
        return ResponseEntity.ok("Инвентарь успешно обновлен");
    }
}
