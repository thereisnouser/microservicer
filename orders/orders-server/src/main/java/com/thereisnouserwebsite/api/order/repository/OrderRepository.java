package com.thereisnouserwebsite.api.order.repository;

import com.thereisnouserwebsite.order.client.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
