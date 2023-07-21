package com.quiz_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quiz_app.model.Question;

public interface QuestionDAO extends JpaRepository<Question, Integer>{

	List<Question> findByCategory(String category);

	@Query(value = "select * from question where category=:category order by rand() limit :numQ",nativeQuery =true )
	List<Question> findRandomQuestionByCategory(String category, int numQ);


}
