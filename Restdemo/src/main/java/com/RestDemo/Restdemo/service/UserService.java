package com.RestDemo.Restdemo.service;

import com.RestDemo.Restdemo.dto.CreateUserDto;
import com.RestDemo.Restdemo.dto.UserDto;
import com.RestDemo.Restdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final  UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        return this.userRepository.findAll();
    }

    public UserDto getUserById(String id) {
        return userRepository.getUserById(id);
    }

    public UserDto save(CreateUserDto createUserDto) {
        return userRepository.save(createUserDto);
    }
}
