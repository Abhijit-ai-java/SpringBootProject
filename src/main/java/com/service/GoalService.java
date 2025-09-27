package com.service;

import java.util.List;

import com.model.Goal;

public interface GoalService {
	
	public Goal saveGoal(Goal goal);
	
	public List<Goal> getGoalsByUserId(Long userId);
	
	public Goal updateGoal(Long id, Goal goal);
	
	void deleteGoal(Long Id);
	
	public List<Goal> getAllGoals();
	

}
