package com.example.demo.service;

import com.example.demo.dto.ExerciseDTO;
import com.example.demo.dto.WorkoutPlanDTO;
import com.example.demo.model.Exercise;
import com.example.demo.model.WorkoutPlan;
import com.example.demo.repository.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutPlanService {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    public WorkoutPlanDTO createWorkoutPlan(WorkoutPlanDTO workoutPlanDTO) {
        // Map WorkoutPlanDTO to WorkoutPlan
        WorkoutPlan workoutPlan = mapToEntity(workoutPlanDTO);
        // Save the WorkoutPlan entity to the database
        WorkoutPlan savedWorkoutPlan = workoutPlanRepository.save(workoutPlan);
        // Convert the saved entity back to WorkoutPlanDTO
        return convertToDTO(savedWorkoutPlan);
    }

    public List<WorkoutPlanDTO> getAllWorkoutPlans() {
        List<WorkoutPlan> workoutPlans = workoutPlanRepository.findAll();
        return workoutPlans.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public WorkoutPlanDTO addExerciseToWorkoutPlan(Long id, ExerciseDTO exerciseDTO) {
        WorkoutPlan workoutPlan = workoutPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout plan not found"));

        Exercise exercise = convertToEntity(exerciseDTO);
        workoutPlan.getExercises().add(exercise);

        workoutPlan = workoutPlanRepository.save(workoutPlan);
        return convertToDTO(workoutPlan);
    }

    private WorkoutPlanDTO convertToDTO(WorkoutPlan workoutPlan) {
        WorkoutPlanDTO dto = new WorkoutPlanDTO();
        dto.setId(workoutPlan.getId());
        dto.setName(workoutPlan.getName());
        dto.setDescription(workoutPlan.getDescription());
        // Convert and set other properties if needed
        return dto;
    }

    private WorkoutPlan mapToEntity(WorkoutPlanDTO workoutPlanDTO) {
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setName(workoutPlanDTO.getName());
        workoutPlan.setDescription(workoutPlanDTO.getDescription());
        // Map other fields as needed
        return workoutPlan;
    }

    private Exercise convertToEntity(ExerciseDTO exerciseDTO) {
        Exercise exercise = new Exercise();
        exercise.setName(exerciseDTO.getName());
        exercise.setDuration(exerciseDTO.getDuration());
        exercise.setType(exerciseDTO.getType());
        // Convert and set other properties if needed
        return exercise;
    }
}
