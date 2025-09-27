package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.WorkoutSession;

public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, Long>{

}
