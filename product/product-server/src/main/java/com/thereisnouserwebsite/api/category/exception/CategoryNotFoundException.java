package com.thereisnouserwebsite.api.category.exception;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(final String message) {
        super(message);
    }
}
