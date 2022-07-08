package com.thereisnouserwebsite.api.order.service;

import com.thereisnouserwebsite.api.order.exception.OrderNotFoundException;
import com.thereisnouserwebsite.api.order.repository.OrderRepository;
import com.thereisnouserwebsite.order.client.dto.OrderCreateDto;
import com.thereisnouserwebsite.order.client.dto.OrderResponseDto;
import com.thereisnouserwebsite.order.client.dto.OrderUpdateDto;
import com.thereisnouserwebsite.order.client.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderResponseDto> getAllOrders() {
        return orderRepository
                .findAll()
                .stream()
                .map(OrderResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<OrderResponseDto> getOrderById(final long id) {
        final Order order = findOrderByIdOrThrowException(id);
        return createListWithEntityMappedToDto(order);
    }

    public List<OrderResponseDto> createOrder(final OrderCreateDto dto) {
        final LocalDate departureDate = LocalDate.now();
        final LocalDate arrivalDate = departureDate.plusDays(3);

        // TODO: Send request to product and customer services and receive it's data by ids
        final Order dtoMappedToEntity = new Order(
                dto.getProductId(),
                "<product_name>",
                new BigDecimal("1.00"),
                dto.getCustomerId(),
                "<customer_name>",
                "<customer_address",
                departureDate,
                arrivalDate
        );

        final Order createdOrder = orderRepository.save(dtoMappedToEntity);

        return createListWithEntityMappedToDto(createdOrder);
    }

    public List<OrderResponseDto> updateOrder(final long id, final OrderUpdateDto dto) {
        final Order orderToUpdate = findOrderByIdOrThrowException(id);

        if (dto.getProductId() != null) {
            // TODO: Send request to product service and receive it's data by id
            // TODO: Set new product info to order
        }
        if (dto.getCustomerId() != null) {
            // TODO: Send request to customer service and receive it's data by id
            // TODO: Set new customer info to order
        }

        final Order updatedOrder = orderRepository.save(orderToUpdate);

        return createListWithEntityMappedToDto(updatedOrder);
    }

    public List<OrderResponseDto> removeOrderById(final long id) {
        final Order orderToRemove = findOrderByIdOrThrowException(id);

        orderRepository.deleteById(id);

        return createListWithEntityMappedToDto(orderToRemove);
    }

    private Order findOrderByIdOrThrowException(final long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new OrderNotFoundException("Order with 'id' = " + id + " is not found")
        );
    }

    private List<OrderResponseDto> createListWithEntityMappedToDto(final Order entity) {
        return List.of(new OrderResponseDto(entity));
    }
}
