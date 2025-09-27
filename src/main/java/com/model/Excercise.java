package com.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Excercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	@OneToMany(mappedBy = "excercise")
	@JsonIgnore
	private Set<WorkoutLog> workoutLogs;

	public Excercise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Excercise(Long id, String name, String description, Set<WorkoutLog> workoutLogs) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.workoutLogs = workoutLogs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<WorkoutLog> getWorkoutLogs() {
		return workoutLogs;
	}

	public void setWorkoutLogs(Set<WorkoutLog> workoutLogs) {
		this.workoutLogs = workoutLogs;
	}
	

}
