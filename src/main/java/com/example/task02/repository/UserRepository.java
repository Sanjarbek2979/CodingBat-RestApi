package com.example.task02.repository;

import com.example.task02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sanjarbek Allayev, чт 18:16. 10.03.2022
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
