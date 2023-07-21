package com.quiz_app.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz_app.dao.QuestionDAO;
import com.quiz_app.dao.QuizDAO;
import com.quiz_app.model.Question;
import com.quiz_app.model.QuestionWrapper;
import com.quiz_app.model.Quiz;
import com.quiz_app.model.Response;

@Service
public class QuizServices {

	@Autowired
	QuizDAO quizDAO;
	@Autowired
	QuestionDAO questionDAO;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

		List<Question> questions = questionDAO.findRandomQuestionByCategory(category, numQ);

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		quizDAO.save(quiz);

		return new ResponseEntity<>("success", HttpStatus.CREATED);

	}


	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {
		Optional<Quiz> quiz = quizDAO.findById(id);
		List<Question> questionForDB = quiz.get().getQuestion();
		List<QuestionWrapper> questionForUser = new ArrayList<>();

		for (Question q : questionForDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),
					q.getOption3(), q.getOption4());
			questionForUser.add(qw);
		}
		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
	}


	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
		Quiz quiz = quizDAO.findById(id).get();
		List<Question> questions = quiz.getQuestion();
		int right = 0;
		int i = 0;
		for(Response response: responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;
			i++;
			
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}


}
