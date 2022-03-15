package com.example.task02.repository;

import com.example.task02.entity.Answer;
import com.example.task02.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sanjarbek Allayev, чт 18:15. 10.03.2022
 */
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
