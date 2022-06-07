package com.thereisnouserwebsite.product.service;

import com.thereisnouserwebsite.product.dto.ProductCreateDto;
import com.thereisnouserwebsite.product.dto.ProductResponseDto;
import com.thereisnouserwebsite.product.dto.ProductUpdateDto;
import com.thereisnouserwebsite.product.entity.Product;
import com.thereisnouserwebsite.product.exception.ProductNotFoundException;
import com.thereisnouserwebsite.product.repository.ProductRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(final ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductResponseDto> getAllProducts() {
        return repository
            .findAll()
            .stream()
            .map(ProductResponseDto::new)
            .collect(Collectors.toList());
    }

    public List<ProductResponseDto> getProductById(final Long id) {
        final Product product = findProductByIdOrThrowException(id);
        return createListWithEntityMappedToDto(product);
    }

    public List<ProductResponseDto> createProduct(final ProductCreateDto dto) {
        final Product dtoMappedToEntity = new Product(dto.getName(), dto.getQuantity());
        final Product savedProduct = repository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(savedProduct);
    }

    public List<ProductResponseDto> updateProduct(final ProductUpdateDto dto) {
        findProductByIdOrThrowException(dto.getId());

        final Product dtoMappedToEntity = new Product(dto.getId(), dto.getName(), dto.getQuantity());
        final Product updatedProduct = repository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(updatedProduct);
    }

    public List<ProductResponseDto> removeProductById(final Long id) {
        final Product productToRemove = findProductByIdOrThrowException(id);

        repository.deleteById(id);

        return createListWithEntityMappedToDto(productToRemove);
    }

    private Product findProductByIdOrThrowException(final Long id) {
        return repository.findById(id).orElseThrow(
            () -> new ProductNotFoundException("Product with 'id' = " + id + " is not found")
        );
    }

    private List<ProductResponseDto> createListWithEntityMappedToDto(final Product entity) {
        return Arrays.asList(new ProductResponseDto(entity));
    }
}
