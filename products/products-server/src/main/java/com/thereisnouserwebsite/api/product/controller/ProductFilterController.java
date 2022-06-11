package com.thereisnouserwebsite.api.product.controller;

import com.thereisnouserwebsite.api.product.service.ProductService;
import com.thereisnouserwebsite.product.client.dto.ProductResponseDto;
import com.thereisnouserwebsite.product.client.response.ProductResponse;
import com.thereisnouserwebsite.shared.EndpointPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(EndpointPath.PRODUCTS_FILTER)
public class ProductFilterController {

    private final ProductService service;

    @Autowired
    public ProductFilterController(final ProductService service) {
        this.service = service;
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Object> filterByCategoryId(@PathVariable("id") @Min(1) final Long id) {
        final List<ProductResponseDto> products = service.filterByCategoryId(id);
        return createSuccessResponseWithData(products);
    }

    private ResponseEntity<Object> createSuccessResponseWithData(final List<ProductResponseDto> products) {
        final ProductResponse response = new ProductResponse(HttpStatus.OK.value(), "Success", products);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
