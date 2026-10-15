package com.RestDemo.Restdemo.repository;

import com.RestDemo.Restdemo.dto.CreateUserDto;
import com.RestDemo.Restdemo.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class UserRepository {
    List<UserDto> users = new ArrayList<>();

    public UserRepository() {
        users.add(new UserDto(UUID.randomUUID().toString(), "Satya", "satya@tek.com"));
        users.add(new UserDto(UUID.randomUUID().toString(), "Rahul", "rahul@tek.com"));
        users.add(new UserDto(UUID.randomUUID().toString(), "Kiran", "kiran@tek.com"));

    }

    public List<UserDto> findAll() {
        return this.users;
    }

    public UserDto getUserById(String id) {
       for(UserDto user: users) {
           if(Objects.equals(user.getId(), id)) return user;
       }
       return null;
    }

    public UserDto save(CreateUserDto createUserDto) {
        UserDto user = new UserDto(UUID.randomUUID().toString(), createUserDto.getName(), createUserDto.getEmail());
        users.add(user);
        return user;
    }
}
