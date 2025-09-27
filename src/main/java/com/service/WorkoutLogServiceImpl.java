package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ExcerciseRepository;
import com.dao.WorkoutLogRepository;
import com.dao.WorkoutSessionRepository;
import com.model.Excercise;
import com.model.WorkoutLog;
import com.model.WorkoutSession;

public class WorkoutLogServiceImpl implements WorkoutLogService {
	
	@Autowired
	WorkoutSessionRepository workoutSessionRepository;
	
	@Autowired
	WorkoutLogRepository workoutLogRepository;
	
	@Autowired
	ExcerciseRepository excerciseRepository;
	
	@Override
	public WorkoutLog saveWorkoutLog(WorkoutLog workoutLog) {
		//Ensure WorkoutSession exists
		Long sessionId = workoutLog.getWorkoutSession().getId();
		
		WorkoutSession session = workoutSessionRepository.findById(sessionId)
				.orElseThrow(() -> new RuntimeException("WorkoutSession not found: "+ sessionId));
		
		//Ensure Exercise exists
		Long excerciseId = workoutLog.getExcercise().getId();
		Excercise excercise = excerciseRepository.findById(excerciseId)
				.orElseThrow(() -> new RuntimeException("Excercise not found: "+ excerciseId));
		
		workoutLog.setWorkoutSession(session);
		workoutLog.setExcercise(excercise);
		
		return workoutLogRepository.save(workoutLog);
	}

	@Override
	public List<WorkoutLog> getAllWorkoutLogs() {
		
		return workoutLogRepository.findAll();
	}

	@Override
	public WorkoutLog getWorkoutLogById(Long id) {
		
		return workoutLogRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("WorkoutLog not found with id: "+id));
	}

	@Override
	public List<WorkoutLog> getWorkoutLogsBySession(Long sessionId) {
		
		return workoutLogRepository.findByWorkoutSessionId(sessionId);
	}

	@Override
	public WorkoutLog updateWorkoutLog(WorkoutLog workoutLog) {
		
		if(!workoutLogRepository.existsById(workoutLog.getId()))
		{
			throw new RuntimeException("WorkoutLog not found with id: "+ workoutLog.getId());
		}
		return workoutLogRepository.save(workoutLog);
	}

	@Override
	public void deleteWorkoutLog(Long id) {
		
		if(!workoutLogRepository.existsById(id))
		{
			throw new RuntimeException("WorkoutLog not found with id: "+ id);
		}
		workoutLogRepository.deleteById(id);
		
	}
	
}
