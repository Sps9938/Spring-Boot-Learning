package com.example.SpringJpaDemo.controller;

import com.example.SpringJpaDemo.dto.CreateUserDto;
import com.example.SpringJpaDemo.dto.UserDto;
import com.example.SpringJpaDemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    //create user
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(createUserDto));
    }


    //get user
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    //get user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    //delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //path user -> name or email
    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> patchUser(@PathVariable Long id, @RequestBody CreateUserDto patchUserDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.patchUser(id, patchUserDto));
    }


    //update user by id
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable Long id, @RequestBody CreateUserDto UpdateUserDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserById(id, UpdateUserDto));
    }

}
