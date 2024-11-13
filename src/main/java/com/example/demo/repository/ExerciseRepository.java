package com.example.demo.repository;

import com.example.demo.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByWorkoutPlanId(Long workoutPlanId);
}
