package com.backend.novahold.service;

import com.backend.novahold.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAllProducts();

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto);

    void deleteProduct(int productId);
}
