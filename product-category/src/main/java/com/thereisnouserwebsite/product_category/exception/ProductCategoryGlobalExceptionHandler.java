package com.thereisnouserwebsite.product_category.exception;

import com.thereisnouserwebsite.product_category.response.ProductCategoryResponse;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ProductCategoryGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        final MethodArgumentNotValidException e,
        final HttpHeaders headers,
        final HttpStatus status,
        final WebRequest request
    ) {
        final StringBuilder messageBuilder = new StringBuilder();

        for (FieldError fieldError : e.getFieldErrors()) {
            messageBuilder.append("'" + fieldError.getField() + "' " + fieldError.getDefaultMessage() + "; ");
        }
        messageBuilder.deleteCharAt(messageBuilder.length() - 1);

        return new ResponseEntity(
            new ProductCategoryResponse(
                HttpStatus.UNPROCESSABLE_ENTITY,
                messageBuilder.toString()),
            HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(ProductCategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity handleProductCategoryNotFoundException(final ProductCategoryNotFoundException e) {
        final ProductCategoryResponse response = new ProductCategoryResponse(HttpStatus.NOT_FOUND,
                                                                             e.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleConstraintViolationException(final ConstraintViolationException e) {
        final ProductCategoryResponse response = new ProductCategoryResponse(HttpStatus.BAD_REQUEST,
                                                                             e.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handleAllUncaughtException(final Exception e) {
        final ProductCategoryResponse response = new ProductCategoryResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                                                                             e.getMessage());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
