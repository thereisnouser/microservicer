package com.thereisnouserwebsite.api.product.controller;

import com.thereisnouserwebsite.api.product.service.ProductService;
import com.thereisnouserwebsite.product.client.dto.ProductCreateDto;
import com.thereisnouserwebsite.product.client.dto.ProductResponseDto;
import com.thereisnouserwebsite.product.client.dto.ProductUpdateDto;
import com.thereisnouserwebsite.product.client.response.ProductResponse;
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
@RequestMapping(EndpointPath.PRODUCTS)
@Validated
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(final ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getAllProducts() {
        final List<ProductResponseDto> products = service.getAllProducts();
        return createSuccessResponseWithData(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") @Min(1) final Long id) {
        final List<ProductResponseDto> product = service.getProductById(id);
        return createSuccessResponseWithData(product);
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@Valid @RequestBody final ProductCreateDto dto) {
        final List<ProductResponseDto> createdProduct = service.createProduct(dto);
        return createSuccessResponseWithData(createdProduct);
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@Valid @RequestBody final ProductUpdateDto dto) {
        final List<ProductResponseDto> updatedProduct = service.updateProduct(dto);
        return createSuccessResponseWithData(updatedProduct);
    }

    @PatchMapping("/{productId}/category/{categoryId}")
    public ResponseEntity<Object> addCategoryToProductById(
            @PathVariable("productId") @Min(1) final Long productId,
            @PathVariable("categoryId") @Min(1) final Long categoryId
    ) {
        final List<ProductResponseDto> updatedProduct = service.addCategoryToProductById(categoryId, productId);
        return createSuccessResponseWithData(updatedProduct);
    }

    @DeleteMapping("/{productId}/category/{categoryId}")
    public ResponseEntity<Object> removeCategoryFromProductById(
            @PathVariable("productId") @Min(1) final Long productId,
            @PathVariable("categoryId") @Min(1) final Long categoryId
    ) {
        final List<ProductResponseDto> updatedProduct = service.removeCategoryFromProductById(categoryId, productId);
        return createSuccessResponseWithData(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeProductById(@PathVariable("id") @Min(1) final Long id) {
        final List<ProductResponseDto> removedProduct = service.removeProductById(id);
        return createSuccessResponseWithData(removedProduct);
    }

    private ResponseEntity<Object> createSuccessResponseWithData(final List<ProductResponseDto> products) {
        final ProductResponse response = new ProductResponse(HttpStatus.OK.value(), "Success", products);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
