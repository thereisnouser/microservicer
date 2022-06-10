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

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(final CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryResponseDto> getAllCategories() {
        return repository
                .findAll()
                .stream()
                .map(CategoryResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<CategoryResponseDto> getCategoryById(final Long id) {
        final Category category = findCategoryByIdOrThrowException(id);
        return createListWithEntityMappedToDto(category);
    }

    public List<CategoryResponseDto> createCategory(final CategoryCreateDto dto) {
        final Category dtoMappedToEntity = new Category(dto.getName());
        final Category createdCategory = repository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(createdCategory);
    }

    public List<CategoryResponseDto> updateCategory(final CategoryUpdateDto dto) {
        findCategoryByIdOrThrowException(dto.getId());

        final Category dtoMappedToEntity = new Category(dto.getId(), dto.getName());
        final Category updatedCategory = repository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(updatedCategory);
    }

    public List<CategoryResponseDto> removeCategory(final Long id) {
        final Category categoryToRemove = findCategoryByIdOrThrowException(id);

        repository.deleteById(id);

        return createListWithEntityMappedToDto(categoryToRemove);
    }

    private Category findCategoryByIdOrThrowException(final Long id) {
        return repository.findById(id).orElseThrow(
            () -> new CategoryNotFoundException("Category with 'id' = " + id + " is not found")
        );
    }

    private List<CategoryResponseDto> createListWithEntityMappedToDto(final Category entity) {
        return List.of(new CategoryResponseDto(entity));
    }
}
