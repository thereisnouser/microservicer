package com.thereisnouserwebsite.api.customer.repository;

import com.thereisnouserwebsite.customer.client.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
