package com.service;

import java.util.List;

import com.model.WorkoutLog;

public interface WorkoutLogService {
		
		WorkoutLog saveWorkoutLog(WorkoutLog workoutLog);
		
		List<WorkoutLog> getAllWorkoutLogs();
		
		WorkoutLog getWorkoutLogById(Long id);
		
		List<WorkoutLog> getWorkoutLogsBySession(Long sessionId);
		
		WorkoutLog updateWorkoutLog(WorkoutLog workoutLog);
		
		void deleteWorkoutLog(Long id);
}
