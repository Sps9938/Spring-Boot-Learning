package com.example.SpringJpaDemo.controller;

import com.example.SpringJpaDemo.dto.CreateOrderDto;
import com.example.SpringJpaDemo.dto.OrderDto;
import com.example.SpringJpaDemo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;


    @PostMapping("/{userId}")
    public ResponseEntity<OrderDto> createOrder(@PathVariable Long userId, @RequestBody CreateOrderDto createOrderDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(userId, createOrderDto));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long productId) {
        orderService.deleteOrder(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderDto>> getOrderByUserId(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderByUserId(userId));
    }



























}
