package com.example.demo.dto;

import lombok.Data;

@Data
public class ExerciseDTO {
    private Long id;
    private String name;
    private String description;
    private String type;       // Added type field
    private Integer duration;
    private Integer repetitions;
}
