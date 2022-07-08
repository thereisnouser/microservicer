package com.thereisnouserwebsite.api.category.service;

import com.thereisnouserwebsite.api.category.exception.CategoryNotFoundException;
import com.thereisnouserwebsite.api.category.repository.CategoryRepository;
import com.thereisnouserwebsite.category.client.dto.CategoryCreateDto;
import com.thereisnouserwebsite.category.client.dto.CategoryResponseDto;
import com.thereisnouserwebsite.category.client.dto.CategoryUpdateDto;
import com.thereisnouserwebsite.category.client.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(CategoryResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<CategoryResponseDto> getCategoryById(final long id) {
        final Category category = findCategoryByIdOrThrowException(id);
        return createListWithEntityMappedToDto(category);
    }

    public List<CategoryResponseDto> createCategory(final CategoryCreateDto dto) {
        final Category dtoMappedToEntity = new Category(dto.getName());
        final Category createdCategory = categoryRepository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(createdCategory);
    }

    public List<CategoryResponseDto> updateCategory(final long id, final CategoryUpdateDto dto) {
        findCategoryByIdOrThrowException(id);

        final Category dtoMappedToEntity = new Category(id, dto.getName());
        final Category updatedCategory = categoryRepository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(updatedCategory);
    }

    public List<CategoryResponseDto> removeCategory(final long id) {
        final Category categoryToRemove = findCategoryByIdOrThrowException(id);

        categoryRepository.deleteById(id);

        return createListWithEntityMappedToDto(categoryToRemove);
    }

    private Category findCategoryByIdOrThrowException(final long id) {
        return categoryRepository.findById(id).orElseThrow(
            () -> new CategoryNotFoundException("Category with 'id' = " + id + " is not found")
        );
    }

    private List<CategoryResponseDto> createListWithEntityMappedToDto(final Category entity) {
        return List.of(new CategoryResponseDto(entity));
    }
}
