package com.example.task02.service;

import com.example.task02.dto.ApiResponse;
import com.example.task02.dto.MarkDTO;
import com.example.task02.entity.Answer;
import com.example.task02.entity.Mark;
import com.example.task02.repository.AnswerRepository;
import com.example.task02.repository.MarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sanjarbek Allayev, чт 18:17. 10.03.2022
 */
@Service
@RequiredArgsConstructor
public class MarkService {
    final AnswerRepository answerRepository;
    final MarkRepository markRepository;

    public List<Mark> getAll() {
        return markRepository.findAll();
    }

    public ApiResponse getOne(Integer id) {
        Optional<Mark> byId = markRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Mark not found",false);
        return new ApiResponse("Mana",true,byId.get());
    }
    public ApiResponse save(MarkDTO dto) {
        Mark mark= new Mark();
        mark.setValue(dto.getValue());
        Optional<Answer> byId = answerRepository.findById(dto.getAnswerId());
        if (byId.isEmpty()) return new ApiResponse("Xatolik",false);
        mark.setAnswer(byId.get());
        Mark save = markRepository.save(mark);
        return new ApiResponse("Added",true,save);
    }
    public ApiResponse edit(Integer id,MarkDTO dto) {
        Optional<Mark> byId1 = markRepository.findById(id);
        if (!byId1.isPresent()) return new ApiResponse("Xatolik",false);
        Mark mark = byId1.get();
        mark.setValue(dto.getValue());
        Optional<Answer> byId = answerRepository.findById(dto.getAnswerId());
        if (byId.isEmpty()) return new ApiResponse("Xatolik",false);
        mark.setAnswer(byId.get());
        Mark save = markRepository.save(mark);
        return new ApiResponse("Edited",true,save);
    }
    public ApiResponse delete(Integer id) {
        markRepository.deleteById(id);
        return new ApiResponse("Deleted",true);
    }
}
