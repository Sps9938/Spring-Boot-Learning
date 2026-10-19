package com.example.SpringJpaDemo.repository;

import com.example.SpringJpaDemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
