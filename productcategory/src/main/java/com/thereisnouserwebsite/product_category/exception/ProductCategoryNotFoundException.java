package com.thereisnouserwebsite.product_category.exception;

public class ProductCategoryNotFoundException extends RuntimeException {

    public ProductCategoryNotFoundException(final String message) {
        super(message);
    }
}
