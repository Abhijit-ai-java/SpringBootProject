package com.service;

import java.util.List;

import com.model.WorkoutSession;

public interface WorkoutSessionService {
	
	public WorkoutSession saveWorkoutSession(WorkoutSession workoutSession);
	
	public List<WorkoutSession> getAllWorkoutSessions();
	
}
