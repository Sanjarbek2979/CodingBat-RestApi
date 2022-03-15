package com.example.task02.controller;

import com.example.task02.dto.ApiResponse;

import com.example.task02.dto.QuestionDTO;
import com.example.task02.entity.Question;

import com.example.task02.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sanjarbek Allayev, чт 18:52. 10.03.2022
 */
@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionController {
    final QuestionService questionService;


    @GetMapping
    public HttpEntity<?>getAll(){
        List<Question> all=questionService.getAll();
        return ResponseEntity.ok().body(all);
    }
    @GetMapping("/{id}")
    public HttpEntity<?>getOne(@PathVariable Integer id){
        ApiResponse apiResponse=questionService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.FOUND:HttpStatus.NOT_FOUND).body(apiResponse);
    }
    @PostMapping
    public HttpEntity<?>save(@RequestBody QuestionDTO dto){
        ApiResponse apiResponse=questionService.save(dto);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?>edit(@PathVariable Integer id,@RequestBody QuestionDTO dto){
        ApiResponse apiResponse=questionService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.ACCEPTED:HttpStatus.NOT_MODIFIED).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?>delete(@PathVariable Integer id){
        ApiResponse apiResponse= questionService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.ACCEPTED:HttpStatus.CONFLICT).body(apiResponse);
    }
}
