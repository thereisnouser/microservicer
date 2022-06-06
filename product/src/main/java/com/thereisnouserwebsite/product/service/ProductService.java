package com.thereisnouserwebsite.product.service;

import com.thereisnouserwebsite.product.dto.ProductRequestDto;
import com.thereisnouserwebsite.product.entity.Product;
import com.thereisnouserwebsite.product.exception.BadRequestException;
import com.thereisnouserwebsite.product.exception.ProductNotFoundException;
import com.thereisnouserwebsite.product.repository.ProductRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductRequestDto> getAllProducts() {
        return productRepository
            .findAll()
            .stream()
            .map(ProductRequestDto::new)
            .collect(Collectors.toList());
    }

    public List<ProductRequestDto> getProductById(@Min(1) final Long id) {
        final Product product = findProductByIdOrThrowException(id);
        return entityToListOfRequestDto(product);
    }

    public List<ProductRequestDto> createProduct(@Valid final ProductRequestDto dto) {
        final Product productDtoMappedToEntity = new Product(dto.getName(), dto.getQuantity());
        final Product savedProduct = productRepository.save(productDtoMappedToEntity);

        return entityToListOfRequestDto(savedProduct);
    }

    public List<ProductRequestDto> updateProduct(@Valid final ProductRequestDto dto) {
        final Long dtoId = dto.getId();

        if (dtoId == null) {
            throw new BadRequestException("Field 'id' can not be empty");
        }
        findProductByIdOrThrowException(dtoId);

        final Product productDtoMappedToEntity = new Product(dto.getId(), dto.getName(), dto.getQuantity());
        final Product updatedProduct = productRepository.save(productDtoMappedToEntity);

        return entityToListOfRequestDto(updatedProduct);
    }

    public List<ProductRequestDto> removeProductById(@Min(1) final Long id) {
        final Product productToDelete = findProductByIdOrThrowException(id);

        productRepository.deleteById(id);

        return entityToListOfRequestDto(productToDelete);
    }

    private Product findProductByIdOrThrowException(final Long id) {
        return productRepository.findById(id).orElseThrow(
            () -> new ProductNotFoundException("Product with 'id' = " + id + " is not found")
        );
    }

    private List<ProductRequestDto> entityToListOfRequestDto(final Product entity) {
        return Arrays.asList(new ProductRequestDto(entity));
    }
}
