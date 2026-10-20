package com.example.SpringJpaDemo.dto;

import com.example.SpringJpaDemo.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OrderDto {
    private Long id;
    private String productName;
    private UserDto user;
}
