package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoalRepository;
import com.dao.UserRepository;
import com.exception.ResourceNotFoundException;
import com.model.Goal;
import com.model.User;

@Service
public class GoalServiceImpl implements GoalService {
	
	/*
	 * @Autowired private GoalRepository goalRepository;
	 * 
	 * @Autowired private UserRepository userRepository;
	 */
	
	private final GoalRepository goalRepository;
    private final UserRepository userRepository;
    
    
    public GoalServiceImpl(GoalRepository goalRepository, UserRepository userRepository) {
        this.goalRepository = goalRepository;
        this.userRepository = userRepository;
    }
	
	
	@Override
	public Goal saveGoal(Goal goal) {
		
		Long userId = goal.getUser().getId();
		User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found with id"+ userId));
		goal.setUser(user);
		return goalRepository.save(goal);
	}

	@Override
	public List<Goal> getGoalsByUserId(Long userId) {
		
		return goalRepository.findByUserId(userId);
	}

	/*
	 * @Override public Goal updateGoal(Goal goal) {
	 * 
	 * return goalRepository.save(goal); }
	 */
	
	@Override
	public Goal updateGoal(Long id, Goal updatedGoal) {
	    Goal existingGoal = goalRepository.findById(updatedGoal.getId())
	        .orElseThrow(() -> new RuntimeException("Goal not found with id " + updatedGoal.getId()));

	    existingGoal.setGoalName(updatedGoal.getGoalName());
	    existingGoal.setGoalDescription(updatedGoal.getGoalDescription());
	    existingGoal.setUser(updatedGoal.getUser());

	    return goalRepository.save(existingGoal);
	}

	@Override
	public void deleteGoal(Long id) throws ResourceNotFoundException {
	    if (!goalRepository.existsById(id)) {
	        throw new ResourceNotFoundException("Goal not found with id: " + id);
	    }
	    goalRepository.deleteById(id);
	}


	@Override
	public List<Goal> getAllGoals() {
		
		return goalRepository.findAll();
	}

}
