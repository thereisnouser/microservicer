package com.thereisnouserwebsite.api.order.controller;

import com.thereisnouserwebsite.api.order.service.OrderService;
import com.thereisnouserwebsite.order.client.dto.OrderCreateDto;
import com.thereisnouserwebsite.order.client.dto.OrderResponseDto;
import com.thereisnouserwebsite.order.client.dto.OrderUpdateDto;
import com.thereisnouserwebsite.order.client.response.OrderResponse;
import com.thereisnouserwebsite.shared.EndpointPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(EndpointPath.ORDERS)
@Validated
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(final OrderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getAllOrders() {
        final List<OrderResponseDto> orders = service.getAllOrders();
        return createSuccessResponseWithData(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable("id") @Min(1) final Long id) {
        final List<OrderResponseDto> order = service.getOrderById(id);
        return createSuccessResponseWithData(order);
    }

    @PostMapping
    public ResponseEntity<Object> createOrder(@Valid @RequestBody final OrderCreateDto dto) {
        final List<OrderResponseDto> createdOrder = service.createOrder(dto);
        return createSuccessResponseWithData(createdOrder);
    }

    @PutMapping
    public ResponseEntity<Object> updateOrder(@Valid @RequestBody final OrderUpdateDto dto) {
        final List<OrderResponseDto> updatedOrder = service.updateOrder(dto);
        return createSuccessResponseWithData(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOrderById(@PathVariable("id") @Min(1) final Long id) {
        final List<OrderResponseDto> removedOrder = service.removeOrderById(id);
        return createSuccessResponseWithData(removedOrder);
    }

    private ResponseEntity<Object> createSuccessResponseWithData(final List<OrderResponseDto> data) {
        final OrderResponse response = new OrderResponse(HttpStatus.OK.value(), "Success", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
