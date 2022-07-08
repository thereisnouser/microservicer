package com.thereisnouserwebsite.api.customer.controller;

import com.thereisnouserwebsite.api.customer.service.CustomerService;
import com.thereisnouserwebsite.customer.client.dto.CustomerCreateDto;
import com.thereisnouserwebsite.customer.client.dto.CustomerResponseDto;
import com.thereisnouserwebsite.customer.client.dto.CustomerUpdateDto;
import com.thereisnouserwebsite.customer.client.response.CustomerResponse;
import com.thereisnouserwebsite.shared.EndpointPath;
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

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(EndpointPath.CUSTOMERS)
@Validated
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllCustomers() {
        final List<CustomerResponseDto> customers = customerService.getAllCustomers();
        return createSuccessResponseWithData(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") @Min(1) final Long id) {
        final List<CustomerResponseDto> customer = customerService.getCustomerById(id);
        return createSuccessResponseWithData(customer);
    }

    @PostMapping
    public ResponseEntity<Object> createCustomer(@Valid @RequestBody final CustomerCreateDto dto) {
        final List<CustomerResponseDto> createdCustomer = customerService.createCustomer(dto);
        return createSuccessResponseWithData(createdCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(
            @PathVariable("id") @Min(1) final Long id,
            @Valid @RequestBody final CustomerUpdateDto dto
    ) {
        final List<CustomerResponseDto> updatedCustomer = customerService.updateCustomer(id, dto);
        return createSuccessResponseWithData(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeCustomerById(@PathVariable("id") @Min(1) final Long id) {
        final List<CustomerResponseDto> removedCustomer = customerService.removeCustomerById(id);
        return createSuccessResponseWithData(removedCustomer);
    }

    private ResponseEntity<Object> createSuccessResponseWithData(final List<CustomerResponseDto> data) {
        final CustomerResponse response = new CustomerResponse(HttpStatus.OK.value(), "Success", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
