package com.example.demo.repository;

import com.example.demo.model.WorkoutPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
    List<WorkoutPlan> findByUserId(Long userId);

    // Optional pagination support
    Page<WorkoutPlan> findByUserId(Long userId, Pageable pageable);
}
