package com.thereisnouserwebsite.product.controller;

import com.thereisnouserwebsite.product.dto.ProductCreateDto;
import com.thereisnouserwebsite.product.dto.ProductResponseDto;
import com.thereisnouserwebsite.product.dto.ProductUpdateDto;
import com.thereisnouserwebsite.product.response.ProductResponse;
import com.thereisnouserwebsite.product.service.ProductService;
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
@RequestMapping("api/v1/products")
@Validated
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(final ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        final List<ProductResponseDto> products = service.getAllProducts();
        return createSuccessResponseWithData(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") @Min(1) final Long id) {
        final List<ProductResponseDto> product = service.getProductById(id);
        return createSuccessResponseWithData(product);
    }

    @PostMapping
    public ResponseEntity createProduct(@Valid @RequestBody final ProductCreateDto dto) {
        final List<ProductResponseDto> createdProduct = service.createProduct(dto);
        return createSuccessResponseWithData(createdProduct);
    }

    @PutMapping
    public ResponseEntity updateProduct(@Valid @RequestBody final ProductUpdateDto dto) {
        final List<ProductResponseDto> updatedProduct = service.updateProduct(dto);
        return createSuccessResponseWithData(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeProductById(@PathVariable("id") @Min(1) final Long id) {
        final List<ProductResponseDto> removedProduct = service.removeProductById(id);
        return createSuccessResponseWithData(removedProduct);
    }

    private ResponseEntity createSuccessResponseWithData(final List<ProductResponseDto> products) {
        final ProductResponse response = new ProductResponse(HttpStatus.OK, "Success", products);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
