package com.thereisnouserwebsite.api.category.controller;

import com.thereisnouserwebsite.api.category.service.CategoryService;
import com.thereisnouserwebsite.category.client.dto.CategoryCreateDto;
import com.thereisnouserwebsite.category.client.dto.CategoryResponseDto;
import com.thereisnouserwebsite.category.client.dto.CategoryUpdateDto;
import com.thereisnouserwebsite.category.client.response.CategoryResponse;
import com.thereisnouserwebsite.shared.EndpointPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(EndpointPath.CATEGORIES)
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllCategories() {
        final List<CategoryResponseDto> categories = categoryService.getAllCategories();
        return createSuccessResponseWithData(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable("id") @Min(1) final Long id) {
        final List<CategoryResponseDto> category = categoryService.getCategoryById(id);
        return createSuccessResponseWithData(category);
    }

    @PostMapping
    public ResponseEntity<Object> createCategory(@Valid @RequestBody final CategoryCreateDto dto) {
        final List<CategoryResponseDto> createdCategory = categoryService.createCategory(dto);
        return createSuccessResponseWithData(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(
            @PathVariable("id") @Min(1) final Long id,
            @Valid @RequestBody final CategoryUpdateDto dto
    ) {
        final List<CategoryResponseDto> updatedCategory = categoryService.updateCategory(id, dto);
        return createSuccessResponseWithData(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeCategory(@PathVariable("id") @Min(1) final Long id) {
        final List<CategoryResponseDto> removedCategory = categoryService.removeCategory(id);
        return createSuccessResponseWithData(removedCategory);
    }

    private ResponseEntity<Object> createSuccessResponseWithData(final List<CategoryResponseDto> data) {
        final CategoryResponse response = new CategoryResponse(HttpStatus.OK.value(), "Success", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
