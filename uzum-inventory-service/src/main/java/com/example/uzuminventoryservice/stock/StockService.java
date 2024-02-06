package com.example.uzuminventoryservice.stock;

import com.example.uzuminventoryservice.common.service.GenericCrudService;
import com.example.uzuminventoryservice.product.ProductFeignClient;
import com.example.uzuminventoryservice.product.ProductResponseDto;
import com.example.uzuminventoryservice.stock.dto.StockCreateDto;
import com.example.uzuminventoryservice.stock.dto.StockResponseDto;
import com.example.uzuminventoryservice.stock.entity.Stock;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class StockService extends GenericCrudService<Stock, UUID, StockCreateDto, StockCreateDto, StockCreateDto, StockResponseDto> {
    private final StockRepository repository;
    private final Class<Stock> EntityClass = Stock.class;
    private final StockDtoMapper mapper;
    private final ProductFeignClient productFeignClient;

    @Override
    protected Stock save(StockCreateDto stockCreateDto) {


        ResponseEntity<ProductResponseDto> product = productFeignClient.getProduct(stockCreateDto.getProductId());

        Stock entity = mapper.toEntity(stockCreateDto);
        return repository.save(entity);
    }

    @Override
    protected Stock updateEntity(StockCreateDto stockCreateDto, Stock stock) {
        return null;
    }

    public StockResponseDto getProductId(String id) {
        Stock stock = repository.getStockByProductId(id).orElseThrow();
        return mapper.toResponseDto(stock);
    }

    public void updateStock(String productId, Integer count) {
        Stock stock = repository.getStockByProductId(productId).orElseThrow();
        stock.setCount(stock.getCount() - count);
        repository.save(stock);
    }


}
