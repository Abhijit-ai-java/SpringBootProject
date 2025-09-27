package com.model;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class WorkoutSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	private User user;
	
	@OneToMany(mappedBy = "workoutSession")
	@JsonIgnore
	private Set<WorkoutLog> workoutLogs;

	public WorkoutSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkoutSession(Long id, LocalDate date, User user, Set<WorkoutLog> workoutLogs) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
		this.workoutLogs = workoutLogs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<WorkoutLog> getWorkoutLogs() {
		return workoutLogs;
	}

	public void setWorkoutLog(Set<WorkoutLog> workoutLogs) {
		this.workoutLogs = workoutLogs;
	}

}
