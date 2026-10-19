package com.example.SpringJpaDemo.service;

import com.example.SpringJpaDemo.dto.CreateUserDto;
import com.example.SpringJpaDemo.dto.UserDto;
import com.example.SpringJpaDemo.entities.User;
import com.example.SpringJpaDemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto saveUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setEmail(createUserDto.getEmail());
        user.setName(createUserDto.getName());

        User saveUser = userRepository.save(user);

        return new UserDto(saveUser.getId(), saveUser.getName(), saveUser.getEmail());


    }

    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user: users){
            UserDto userDto = new UserDto(user.getId(), user.getName(), user.getEmail());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public UserDto patchUser(Long id, CreateUserDto patchUserDto) {
        User user = userRepository.findById(id).orElseThrow();

        if(patchUserDto.getEmail() != null) user.setEmail(patchUserDto.getEmail());
        if(patchUserDto.getName() != null) user.setName(patchUserDto.getName());

        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    @Transactional
    public UserDto updateUserById(Long id, CreateUserDto updateUserDto) {
        User user = userRepository.findById(id).orElseThrow();

        user.setName(updateUserDto.getName());
        user.setEmail(updateUserDto.getEmail());

        return new UserDto(user.getId(), user.getName(), user.getEmail());

    }
}
