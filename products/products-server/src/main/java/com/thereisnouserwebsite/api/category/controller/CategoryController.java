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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(EndpointPath.CATEGORIES)
@Validated
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(final CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getAllCategories() {
        final List<CategoryResponseDto> categories = service.getAllCategories();
        return createSuccessResponseWithData(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable("id") @Min(1) final Long id) {
        final List<CategoryResponseDto> category = service.getCategoryById(id);
        return createSuccessResponseWithData(category);
    }

    @PostMapping
    public ResponseEntity<Object> createCategory(@Valid @RequestBody final CategoryCreateDto dto) {
        final List<CategoryResponseDto> createdCategory = service.createCategory(dto);
        return createSuccessResponseWithData(createdCategory);
    }

    @PutMapping
    public ResponseEntity<Object> updateCategory(@Valid @RequestBody final CategoryUpdateDto dto) {
        final List<CategoryResponseDto> updatedCategory = service.updateCategory(dto);
        return createSuccessResponseWithData(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeCategory(@PathVariable("id") @Min(1) final Long id) {
        final List<CategoryResponseDto> removedCategory = service.removeCategory(id);
        return createSuccessResponseWithData(removedCategory);
    }

    private ResponseEntity<Object> createSuccessResponseWithData(final List<CategoryResponseDto> data) {
        final CategoryResponse response = new CategoryResponse(HttpStatus.OK.value(), "Success", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
