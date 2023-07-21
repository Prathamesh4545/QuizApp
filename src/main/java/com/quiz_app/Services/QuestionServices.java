package com.quiz_app.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.quiz_app.dao.QuestionDAO;
import com.quiz_app.model.Question;

@Service
public class QuestionServices {

	@Autowired
	QuestionDAO questionDAO;
	
	public ResponseEntity<List<Question>> getAllQuestion() {
		try {
			return new ResponseEntity<>(questionDAO.findAll(),HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getCategory(@PathVariable("category")String category) {
		try {
			return new ResponseEntity<>(questionDAO.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
			questionDAO.save(question);
			return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}


}
