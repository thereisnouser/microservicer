package com.thereisnouserwebsite.product_category.controller;

import com.thereisnouserwebsite.product_category.dto.ProductCategoryCreateDto;
import com.thereisnouserwebsite.product_category.dto.ProductCategoryResponseDto;
import com.thereisnouserwebsite.product_category.dto.ProductCategoryUpdateDto;
import com.thereisnouserwebsite.product_category.response.ProductCategoryResponse;
import com.thereisnouserwebsite.product_category.service.ProductCategoryService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
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

@RestController
@RequestMapping("/api/v1/product-categories")
@Validated
public class ProductCategoryController {

    private final ProductCategoryService service;

    @Autowired
    public ProductCategoryController(final ProductCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAllCategories() {
        final List<ProductCategoryResponseDto> result = service.getAllCategories();
        return createSuccessResponseWithData(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategoryById(@PathVariable("id") @Min(1) final Long id) {
        final List<ProductCategoryResponseDto> result = service.getCategoryById(id);
        return createSuccessResponseWithData(result);
    }

    @PostMapping
    public ResponseEntity createCategory(@Valid @RequestBody final ProductCategoryCreateDto dto) {
        final List<ProductCategoryResponseDto> result = service.createCategory(dto);
        return createSuccessResponseWithData(result);
    }

    @PutMapping
    public ResponseEntity updateCategory(@Valid @RequestBody final ProductCategoryUpdateDto dto) {
        final List<ProductCategoryResponseDto> result = service.updateCategory(dto);
        return createSuccessResponseWithData(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeCategory(@PathVariable("id") @Min(1) final Long id) {
        final List<ProductCategoryResponseDto> result = service.removeCategory(id);
        return createSuccessResponseWithData(result);
    }

    private ResponseEntity createSuccessResponseWithData(final List<ProductCategoryResponseDto> data) {
        final ProductCategoryResponse response = new ProductCategoryResponse(HttpStatus.OK, "Success", data);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
