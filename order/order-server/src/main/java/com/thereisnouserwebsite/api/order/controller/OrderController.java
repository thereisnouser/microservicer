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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(EndpointPath.ORDERS)
@Validated
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllOrders() {
        final List<OrderResponseDto> orders = orderService.getAllOrders();
        return createSuccessResponseWithData(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable("id") @Min(1) final Long id) {
        final List<OrderResponseDto> order = orderService.getOrderById(id);
        return createSuccessResponseWithData(order);
    }

    @PostMapping
    public ResponseEntity<Object> createOrder(@Valid @RequestBody final OrderCreateDto dto) {
        final List<OrderResponseDto> createdOrder = orderService.createOrder(dto);
        return createSuccessResponseWithData(createdOrder);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateOrder(
            @PathVariable("id") @Min(1) final Long id,
            @Valid @RequestBody final OrderUpdateDto dto
    ) {
        final List<OrderResponseDto> updatedOrder = orderService.updateOrder(id, dto);
        return createSuccessResponseWithData(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOrderById(@PathVariable("id") @Min(1) final Long id) {
        final List<OrderResponseDto> removedOrder = orderService.removeOrderById(id);
        return createSuccessResponseWithData(removedOrder);
    }

    private ResponseEntity<Object> createSuccessResponseWithData(final List<OrderResponseDto> data) {
        final OrderResponse response = new OrderResponse(HttpStatus.OK.value(), "Success", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
