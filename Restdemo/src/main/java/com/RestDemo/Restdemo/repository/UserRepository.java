package com.RestDemo.Restdemo.repository;

import com.RestDemo.Restdemo.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<UserDto> users = new ArrayList<>();

    public UserRepository() {
        users.add(new UserDto(1L, "Satya", "satya@tek.com"));
        users.add(new UserDto(2L, "Rahul", "rahul@tek.com"));
        users.add(new UserDto(3L, "Kiran", "kiran@tek.com"));

    }

    public List<UserDto> findAll() {
        return this.users;
    }

}
