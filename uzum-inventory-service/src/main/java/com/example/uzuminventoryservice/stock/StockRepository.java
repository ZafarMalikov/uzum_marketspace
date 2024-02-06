package com.example.uzuminventoryservice.stock;

import com.example.uzuminventoryservice.common.repository.GenericSpecificationRepository;
import com.example.uzuminventoryservice.stock.entity.Stock;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StockRepository extends GenericSpecificationRepository<Stock, UUID> {

    Optional<Stock> getStockByProductId(String id);


}
