package com.example.demo.controller;

import com.example.demo.dto.ExerciseDTO;
import com.example.demo.dto.WorkoutPlanDTO;
import com.example.demo.model.WorkoutPlan;
import com.example.demo.service.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workout-plans")
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanService workoutPlanService;

    @PostMapping
    public ResponseEntity<WorkoutPlanDTO> createWorkoutPlan(@RequestBody WorkoutPlanDTO workoutPlanDTO) {
        WorkoutPlanDTO createdPlan = workoutPlanService.createWorkoutPlan(workoutPlanDTO);
        return ResponseEntity.ok(createdPlan);
    }

    @GetMapping
    public ResponseEntity<List<WorkoutPlanDTO>> getAllWorkoutPlans() {
        List<WorkoutPlanDTO> workoutPlans = workoutPlanService.getAllWorkoutPlans();
        return ResponseEntity.ok(workoutPlans);
    }

    @PostMapping("/{id}/exercises")
    public ResponseEntity<WorkoutPlanDTO> addExerciseToWorkoutPlan(
            @PathVariable Long id, @RequestBody ExerciseDTO exerciseDTO) {
        WorkoutPlanDTO updatedPlan = workoutPlanService.addExerciseToWorkoutPlan(id, exerciseDTO);
        return ResponseEntity.ok(updatedPlan);
    }
}
