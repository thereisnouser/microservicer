package com.thereisnouserwebsite.api.product.service;

import com.thereisnouserwebsite.api.category.exception.CategoryNotFoundException;
import com.thereisnouserwebsite.api.category.repository.CategoryRepository;
import com.thereisnouserwebsite.api.product.exception.ProductNotFoundException;
import com.thereisnouserwebsite.api.product.repository.ProductRepository;
import com.thereisnouserwebsite.category.client.entity.Category;
import com.thereisnouserwebsite.product.client.dto.ProductCreateDto;
import com.thereisnouserwebsite.product.client.dto.ProductResponseDto;
import com.thereisnouserwebsite.product.client.dto.ProductUpdateDto;
import com.thereisnouserwebsite.product.client.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository,
                          final CategoryRepository categoryRepository) {
        this.productRepository  = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductResponseDto> getAllProducts() {
        return productRepository
            .findAll()
            .stream()
            .map(ProductResponseDto::new)
            .collect(Collectors.toList());
    }

    public List<ProductResponseDto> filterByCategoryId(final long id) {
        return productRepository
                .findAllByCategoryId(id)
                .stream()
                .map(ProductResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<ProductResponseDto> getProductById(final long id) {
        final Product product = findProductByIdOrThrowException(id);
        return createListWithEntityMappedToDto(product);
    }

    public List<ProductResponseDto> createProduct(final ProductCreateDto dto) {
        final Product dtoMappedToEntity = new Product(dto.getName(), dto.getPrice(), dto.getQuantity());
        final Product savedProduct      = productRepository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(savedProduct);
    }

    public List<ProductResponseDto> updateProduct(final long id, final ProductUpdateDto dto) {
        findProductByIdOrThrowException(id);

        final Product dtoMappedToEntity = new Product(id, dto.getName(), dto.getPrice(), dto.getQuantity());
        final Product updatedProduct    = productRepository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(updatedProduct);
    }

    public List<ProductResponseDto> addCategoryToProductById(final long categoryId, final long productId) {
        final Category category       = findCategoryByIdOrThrowException(categoryId);
        final Product productToUpdate = findProductByIdOrThrowException(productId);

        productToUpdate.addCategory(category);
        final Product updatedProduct = productRepository.save(productToUpdate);

        return createListWithEntityMappedToDto(updatedProduct);
    }

    public List<ProductResponseDto> removeCategoryFromProductById(final long categoryId, final long productId) {
        final Category category       = findCategoryByIdOrThrowException(categoryId);
        final Product productToUpdate = findProductByIdOrThrowException(productId);

        productToUpdate.removeCategory(category);
        final Product updatedProduct = productRepository.save(productToUpdate);

        return createListWithEntityMappedToDto(updatedProduct);
    }

    public List<ProductResponseDto> removeProductById(final long id) {
        final Product productToRemove = findProductByIdOrThrowException(id);

        productRepository.deleteById(id);

        return createListWithEntityMappedToDto(productToRemove);
    }

    private Product findProductByIdOrThrowException(final long id) {
        return productRepository.findById(id).orElseThrow(
            () -> new ProductNotFoundException("Product with 'id' = " + id + " is not found")
        );
    }

    private Category findCategoryByIdOrThrowException(final long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException("Category with 'id' = " + id + " is not found")
        );
    }

    private List<ProductResponseDto> createListWithEntityMappedToDto(final Product entity) {
        return List.of(new ProductResponseDto(entity));
    }
}
