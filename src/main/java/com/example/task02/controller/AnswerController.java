package com.example.task02.controller;

import com.example.task02.dto.AnswerDTO;
import com.example.task02.dto.ApiResponse;
import com.example.task02.entity.Answer;
import com.example.task02.service.AnswerService;
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
@RequestMapping("/api/answer")
@RequiredArgsConstructor
public class AnswerController {
    final AnswerService answerService;


    @GetMapping
    public HttpEntity<?>getAll(){
        List<Answer> all=answerService.getAll();
        return ResponseEntity.ok().body(all);
    }
    @GetMapping("/{id}")
    public HttpEntity<?>getOne(@PathVariable Integer id){
        ApiResponse apiResponse=answerService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.FOUND:HttpStatus.NOT_FOUND).body(apiResponse);
    }
    @PostMapping
    public HttpEntity<?>save(@RequestBody AnswerDTO dto){
        ApiResponse apiResponse=answerService.save(dto);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?>edit(@PathVariable Integer id,@RequestBody AnswerDTO dto){
        ApiResponse apiResponse=answerService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.ACCEPTED:HttpStatus.NOT_MODIFIED).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?>delete(@PathVariable Integer id){
        ApiResponse apiResponse= answerService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.ACCEPTED:HttpStatus.CONFLICT).body(apiResponse);
    }
}
