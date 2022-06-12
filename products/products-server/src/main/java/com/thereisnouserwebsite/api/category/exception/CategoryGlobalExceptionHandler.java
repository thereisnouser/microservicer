package com.thereisnouserwebsite.api.category.exception;

import com.thereisnouserwebsite.category.client.response.CategoryResponse;
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

import javax.validation.ConstraintViolationException;

@RestControllerAdvice(basePackages = { "com.thereisnouserwebsite.api.category" })
public class CategoryGlobalExceptionHandler extends ResponseEntityExceptionHandler {

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
            messageBuilder
                    .append("'")
                    .append(fieldError.getField())
                    .append("' ")
                    .append(fieldError.getDefaultMessage())
                    .append("; ");
        }
        messageBuilder.deleteCharAt(messageBuilder.length() - 1);

        return new ResponseEntity<>(
                new CategoryResponse(
                        HttpStatus.UNPROCESSABLE_ENTITY.value(),
                        messageBuilder.toString()),
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleCategoryNotFoundException(final CategoryNotFoundException e) {
        final CategoryResponse response = new CategoryResponse(HttpStatus.NOT_FOUND.value(),
                                                                             e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConstraintViolationException(final ConstraintViolationException e) {
        final CategoryResponse response = new CategoryResponse(HttpStatus.BAD_REQUEST.value(),
                                                                             e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleAllUncaughtException(final Exception e) {
        final CategoryResponse response = new CategoryResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                             e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
