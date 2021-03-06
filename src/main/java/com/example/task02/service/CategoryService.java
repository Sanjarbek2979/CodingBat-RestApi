package com.example.task02.service;

import com.example.task02.dto.ApiResponse;
import com.example.task02.dto.CategoryDTO;
import com.example.task02.entity.Category;
import com.example.task02.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sanjarbek Allayev, чт 18:17. 10.03.2022
 */
@Service
@RequiredArgsConstructor
public class CategoryService {
    final CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public ApiResponse getOne(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Category not found", false);
        return new ApiResponse("Mana", true, byId.get());
    }

    public ApiResponse save(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        Optional<Category> byId = categoryRepository.findById(dto.getParentCategoryId());
        Category category1 = byId.get();
        category.setParentCategory(category1);
        Category save = categoryRepository.save(category);
        return new ApiResponse("Added", true, save);
    }

    public ApiResponse edit(Integer id, CategoryDTO dto) {

        Optional<Category> byId1 = categoryRepository.findById(id);
        if (byId1.isEmpty()) return new ApiResponse("Xatolik",false);
        Category category = byId1.get();
        category.setName(dto.getName());
        Optional<Category> byId = categoryRepository.findById(dto.getParentCategoryId());
        Category category1 = byId.get();
        category.setParentCategory(category1);
        Category save = categoryRepository.save(category);
        return new ApiResponse("Edited", true, save);
    }
    public ApiResponse delete(Integer id) {
        categoryRepository.deleteById(id);
        return new ApiResponse("Deleted", true);
    }
}
