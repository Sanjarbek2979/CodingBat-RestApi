package com.example.task02.service;

import com.example.task02.dto.ApiResponse;

import com.example.task02.dto.QuestionDTO;
import com.example.task02.entity.Category;
import com.example.task02.entity.Question;
import com.example.task02.repository.CategoryRepository;
import com.example.task02.repository.CategoryRepository;

import com.example.task02.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sanjarbek Allayev, чт 18:17. 10.03.2022
 */
@Service
@RequiredArgsConstructor
public class QuestionService {
    final CategoryRepository categoryRepository;
    final QuestionRepository questionRepository;

    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    public ApiResponse getOne(Integer id) {
        Optional<Question> byId = questionRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Question not found",false);
        return new ApiResponse("Mana",true,byId.get());
    }
    public ApiResponse save(QuestionDTO dto) {
        Question question= new Question();
        question.setText(dto.getText());
        Optional<Category> byId = categoryRepository.findById(dto.getCategoryId());
        if (byId.isEmpty()) return new ApiResponse("Xatolik",false);
        question.setCategory(byId.get());
        Question save = questionRepository.save(question);
        return new ApiResponse("Added",true,save);
    }
    public ApiResponse edit(Integer id,QuestionDTO dto) {
        Optional<Question> byId1 = questionRepository.findById(id);
        if (!byId1.isPresent()) return new ApiResponse("Xatolik",false);
        Question question = byId1.get();
        question.setText(dto.getText());
        Optional<Category> byId = categoryRepository.findById(dto.getCategoryId());
        if (byId.isEmpty()) return new ApiResponse("Xatolik",false);
        question.setCategory(byId.get());
        Question save = questionRepository.save(question);
        return new ApiResponse("Edited",true,save);
    }
    public ApiResponse delete(Integer id) {
        questionRepository.deleteById(id);
        return new ApiResponse("Deleted",true);
    }
}
