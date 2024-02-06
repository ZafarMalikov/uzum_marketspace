package com.example.uzumproductservice.product;

import com.example.uzumproductservice.common.exception.EntityNotFoundException;
import com.example.uzumproductservice.product.dto.ProductCreateDto;
import com.example.uzumproductservice.product.dto.ProductResponseDto;
import com.example.uzumproductservice.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ModelMapper mapper;

    public ProductResponseDto create(ProductCreateDto productCreateDto) {
        Product entity = mapper.map(productCreateDto, Product.class);
        Product save = repository.save(entity);
        return mapper.map(save, ProductResponseDto.class);
    }

    public ProductResponseDto getId(String id) {
        Product product = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("product not found"));

        return mapper.map(product, ProductResponseDto.class);
    }

    public Page<ProductResponseDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(product ->
                mapper.map(product, ProductResponseDto.class));
    }
}
