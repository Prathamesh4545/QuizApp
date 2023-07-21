package com.quiz_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz_app.Services.QuestionServices;
import com.quiz_app.model.Question;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionServices questionServices;
	
	@GetMapping("getAllQuestions") 
	public ResponseEntity<List<Question>> getAllQuestion() {
		return questionServices.getAllQuestion();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getCategory(@PathVariable("category")String category){
		return questionServices.getCategory(category);
	}
	
	@PostMapping("addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionServices.addQuestion(question);
	}
	
}
