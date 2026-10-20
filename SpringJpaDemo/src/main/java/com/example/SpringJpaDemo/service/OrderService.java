package com.example.SpringJpaDemo.service;

import com.example.SpringJpaDemo.dto.CreateOrderDto;
import com.example.SpringJpaDemo.dto.OrderDto;
import com.example.SpringJpaDemo.dto.UserDto;
import com.example.SpringJpaDemo.entities.Order;
import com.example.SpringJpaDemo.entities.User;
import com.example.SpringJpaDemo.repository.OrderRepository;
import com.example.SpringJpaDemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Transactional
    public OrderDto createOrder(Long userId, CreateOrderDto createOrderDto) {
        User user = userRepository.findById(userId).orElseThrow();

        Order order = new Order();

        order.setProductName(createOrderDto.getProductName());
        order.setUser(user);

        Order saveOrder = orderRepository.save(order);

        return new OrderDto(saveOrder.getId(), saveOrder.getProductName(),
                new UserDto(saveOrder.getUser().getId(), saveOrder.getUser().getName(), saveOrder.getUser().getEmail()));

    }

    public void deleteOrder(Long productId) {
        orderRepository.findById(productId).orElseThrow();

        orderRepository.deleteById(productId);
    }


    public List<OrderDto> getOrderByUserId(Long userId) {
        userRepository.findById(userId).orElseThrow();
        List<Order> orders = orderRepository.findByUserId(userId);

        List<OrderDto> orderDtos = new ArrayList<>();
        orders.forEach(order ->{
            OrderDto orderDto = new OrderDto(order.getId(), order.getProductName(),
                    new UserDto(order.getUser().getId(), order.getUser().getName(), order.getUser().getEmail()));
            orderDtos.add(orderDto);
        });
        return orderDtos;
    }


}
