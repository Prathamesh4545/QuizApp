package com.quiz_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz_app.model.Quiz;

public interface QuizDAO extends JpaRepository<Quiz, Integer>{

}
