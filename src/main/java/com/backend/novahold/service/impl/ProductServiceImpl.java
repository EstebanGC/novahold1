package com.backend.novahold.service.impl;

import com.backend.novahold.dto.Mapper;
import com.backend.novahold.dto.ProductDto;
import com.backend.novahold.entity.Product;
import com.backend.novahold.repository.ProductRepository;
import com.backend.novahold.service.ProductService;
import com.backend.novahold.util.BadArgumentsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<ProductDto> findAllProducts() {
        List<ProductDto> productDto = new ArrayList<>();
        productRepository.findAll().forEach(product -> productDto.add(mapper.fromEntityToProductDto(product)));
        return productDto;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) throws BadArgumentsException {
        Product product = mapper.fromProductDtoToEntity(productDto);

        Product savedProduct = productRepository.save(product);

        return mapper.fromEntityToProductDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return mapper.fromEntityToProductDto(productRepository.save(mapper.fromProductDtoToEntity(productDto)));
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }
}
