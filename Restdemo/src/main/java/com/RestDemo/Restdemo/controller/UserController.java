package com.RestDemo.Restdemo.controller;

import com.RestDemo.Restdemo.dto.UserDto;
import com.RestDemo.Restdemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping

    public List<UserDto> getAllUsers() {
        return this.userService.getAllUsers();
    }

}
