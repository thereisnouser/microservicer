package com.thereisnouserwebsite.api.order.service;

import com.thereisnouserwebsite.api.order.exception.OrderNotFoundException;
import com.thereisnouserwebsite.api.order.repository.OrderRepository;
import com.thereisnouserwebsite.order.client.dto.OrderCreateDto;
import com.thereisnouserwebsite.order.client.dto.OrderResponseDto;
import com.thereisnouserwebsite.order.client.dto.OrderUpdateDto;
import com.thereisnouserwebsite.order.client.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderService(final OrderRepository repository) {
        this.repository = repository;
    }

    public List<OrderResponseDto> getAllOrders() {
        return repository
                .findAll()
                .stream()
                .map(OrderResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<OrderResponseDto> getOrderById(final Long id) {
        final Order order = findOrderByIdOrThrowException(id);
        return createListWithEntityMappedToDto(order);
    }

    public List<OrderResponseDto> createOrder(final OrderCreateDto dto) {
        final Order dtoMappedToEntity = new Order(dto.getProductName());
        final Order createdOrder = repository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(createdOrder);
    }

    public List<OrderResponseDto> updateOrder(final OrderUpdateDto dto) {
        findOrderByIdOrThrowException(dto.getId());

        final Order dtoMappedToEntity = new Order(dto.getId(), dto.getProductName());
        final Order updatedOrder = repository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(updatedOrder);
    }

    public List<OrderResponseDto> removeOrderById(final Long id) {
        final Order orderToRemove = findOrderByIdOrThrowException(id);

        repository.deleteById(id);

        return createListWithEntityMappedToDto(orderToRemove);
    }

    private Order findOrderByIdOrThrowException(final Long id) {
        return repository.findById(id).orElseThrow(
                () -> new OrderNotFoundException("Order with 'id' = " + id + " is not found")
        );
    }

    private List<OrderResponseDto> createListWithEntityMappedToDto(final Order entity) {
        return List.of(new OrderResponseDto(entity));
    }
}
