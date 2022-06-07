package com.thereisnouserwebsite.product_category.service;

import com.thereisnouserwebsite.product_category.dto.ProductCategoryCreateDto;
import com.thereisnouserwebsite.product_category.dto.ProductCategoryResponseDto;
import com.thereisnouserwebsite.product_category.dto.ProductCategoryUpdateDto;
import com.thereisnouserwebsite.product_category.entity.ProductCategory;
import com.thereisnouserwebsite.product_category.exception.ProductCategoryNotFoundException;
import com.thereisnouserwebsite.product_category.repository.ProductCategoryRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository repository;

    @Autowired
    public ProductCategoryService(final ProductCategoryRepository repository) {
        this.repository = repository;
    }

    public List<ProductCategoryResponseDto> getAllCategories() {
        return repository
            .findAll()
            .stream()
            .map(ProductCategoryResponseDto::new)
            .collect(Collectors.toList());
    }

    public List<ProductCategoryResponseDto> getCategoryById(final Long id) {
        final ProductCategory category = findCategoryByIdOrThrowException(id);
        return createListWithEntityMappedToDto(category);
    }

    public List<ProductCategoryResponseDto> createCategory(final ProductCategoryCreateDto dto) {
        final ProductCategory dtoMappedToEntity = new ProductCategory(dto.getName());
        final ProductCategory createdCategory = repository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(createdCategory);
    }

    public List<ProductCategoryResponseDto> updateCategory(final ProductCategoryUpdateDto dto) {
        findCategoryByIdOrThrowException(dto.getId());

        final ProductCategory dtoMappedToEntity = new ProductCategory(dto.getId(), dto.getName());
        final ProductCategory updatedCategory = repository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(updatedCategory);
    }

    public List<ProductCategoryResponseDto> removeCategory(final Long id) {
        final ProductCategory categoryToRemove = findCategoryByIdOrThrowException(id);

        repository.deleteById(id);

        return createListWithEntityMappedToDto(categoryToRemove);
    }

    private ProductCategory findCategoryByIdOrThrowException(final Long id) {
        return repository.findById(id).orElseThrow(
            () -> new ProductCategoryNotFoundException("Category with 'id' = " + id + " is not found")
        );
    }

    private List<ProductCategoryResponseDto> createListWithEntityMappedToDto(final ProductCategory entity) {
        return Arrays.asList(new ProductCategoryResponseDto(entity));
    }
}
