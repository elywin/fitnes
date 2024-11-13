package com.example.demo.service;

import com.example.demo.dto.ExerciseDTO;
import com.example.demo.model.Exercise;
import com.example.demo.repository.ExerciseRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Setter
@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<Exercise> getExercisesByWorkoutPlanId(Long workoutPlanId) {
        return exerciseRepository.findByWorkoutPlanId(workoutPlanId);
    }

    public Exercise addExerciseToWorkoutPlan(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public ExerciseDTO createExercise(ExerciseDTO exerciseDTO) {
        return exerciseDTO;
    }

    public List<ExerciseDTO> getAllExercises() {
        return null;
    }
}
