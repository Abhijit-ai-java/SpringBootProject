package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.WorkoutLog;

public interface WorkoutLogRepository extends JpaRepository<WorkoutLog, Long>{
	
	List<WorkoutLog> findByWorkoutSessionId(Long sessionId);
}
