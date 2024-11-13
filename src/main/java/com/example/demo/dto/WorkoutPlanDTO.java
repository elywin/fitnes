package com.example.demo.dto;

import lombok.Data;
import java.util.List;

@Data
public class WorkoutPlanDTO {
    private Long id;
    private String name;
    private String description;
    private List<ExerciseDTO> exercises;
    private Integer duration; // Assuming duration is in minutes
}
