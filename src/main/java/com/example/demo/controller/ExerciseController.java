package com.example.demo.controller;

import com.example.demo.dto.ExerciseDTO;
import com.example.demo.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<ExerciseDTO> createExercise(@RequestBody ExerciseDTO exerciseDTO) {
        ExerciseDTO createdExercise = exerciseService.createExercise(exerciseDTO);
        return ResponseEntity.ok(createdExercise);
    }

    @GetMapping
    public ResponseEntity<List<ExerciseDTO>> getAllExercises() {
        List<ExerciseDTO> exercises = exerciseService.getAllExercises();
        return ResponseEntity.ok(exercises);
    }
}
