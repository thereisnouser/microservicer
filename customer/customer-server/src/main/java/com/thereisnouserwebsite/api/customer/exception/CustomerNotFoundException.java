package com.thereisnouserwebsite.api.customer.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(final String message) {
        super(message);
    }
}
