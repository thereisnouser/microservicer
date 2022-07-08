package com.thereisnouserwebsite.api.customer.service;

import com.thereisnouserwebsite.api.customer.exception.CustomerNotFoundException;
import com.thereisnouserwebsite.api.customer.repository.CustomerRepository;
import com.thereisnouserwebsite.customer.client.dto.CustomerCreateDto;
import com.thereisnouserwebsite.customer.client.dto.CustomerResponseDto;
import com.thereisnouserwebsite.customer.client.dto.CustomerUpdateDto;
import com.thereisnouserwebsite.customer.client.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponseDto> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(CustomerResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<CustomerResponseDto> getCustomerById(final long id) {
        final Customer customer = findCustomerByIdOrThrowException(id);
        return createListWithEntityMappedToDto(customer);
    }

    public List<CustomerResponseDto> createCustomer(final CustomerCreateDto dto) {
        final Customer dtoMappedToEntity = new Customer(
                dto.getName(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getAddress()
        );
        final Customer savedCustomer = customerRepository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(savedCustomer);
    }

    public List<CustomerResponseDto> updateCustomer(final long id, final CustomerUpdateDto dto) {
        findCustomerByIdOrThrowException(id);

        final Customer dtoMappedToEntity = new Customer(
                id,
                dto.getName(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getAddress()
        );
        final Customer updatedCustomer = customerRepository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(updatedCustomer);
    }

    public List<CustomerResponseDto> removeCustomerById(final long id) {
        final Customer customerToRemove = findCustomerByIdOrThrowException(id);

        customerRepository.deleteById(id);

        return createListWithEntityMappedToDto(customerToRemove);
    }

    private Customer findCustomerByIdOrThrowException(final long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer with 'id' = " + id + " is not found")
        );
    }

    private List<CustomerResponseDto> createListWithEntityMappedToDto(final Customer entity) {
        return List.of(new CustomerResponseDto(entity));
    }
}
