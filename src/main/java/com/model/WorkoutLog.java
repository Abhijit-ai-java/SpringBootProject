package com.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WorkoutLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime workoutTime;
	
	private Double duration;
	
	private Integer caloriesBurned;
	
	@ManyToOne
	@JoinColumn(name="workout_sessoin_id")
	private WorkoutSession workoutSession;
	
	@ManyToOne
	@JoinColumn(name="excercise_id")
	private Excercise excercise;

	public WorkoutLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkoutLog(Long id, LocalDateTime workoutTime, Double duration, Integer caloriesBurned,
			WorkoutSession workoutSession, Excercise excercise) {
		super();
		this.id = id;
		this.workoutTime = workoutTime;
		this.duration = duration;
		this.caloriesBurned = caloriesBurned;
		this.workoutSession = workoutSession;
		this.excercise = excercise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getWorkoutTime() {
		return workoutTime;
	}

	public void setWorkoutTime(LocalDateTime workoutTime) {
		this.workoutTime = workoutTime;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Integer getCaloriesBurned() {
		return caloriesBurned;
	}

	public void setCaloriesBurned(Integer caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}

	public WorkoutSession getWorkoutSession() {
		return workoutSession;
	}

	public void setWorkoutSession(WorkoutSession workoutSession) {
		this.workoutSession = workoutSession;
	}

	public Excercise getExcercise() {
		return excercise;
	}

	public void setExcercise(Excercise excercise) {
		this.excercise = excercise;
	}
	

}
