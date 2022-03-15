package com.example.task02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sanjarbek Allayev, чт 18:11. 10.03.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {

private String name;
private Integer parentCategoryId;

}
