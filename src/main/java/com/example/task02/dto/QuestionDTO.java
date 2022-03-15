package com.example.task02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sanjarbek Allayev, чт 17:36. 10.03.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionDTO {

    private String text;
    private Integer categoryId;
}
