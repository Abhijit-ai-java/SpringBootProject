package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Excercise;

public interface ExcerciseRepository extends JpaRepository<Excercise, Long> {

}
