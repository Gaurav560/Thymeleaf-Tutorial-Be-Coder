package com.telusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.QuestionModel;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Responsee;
import com.telusko.service.QuizService;

import jakarta.persistence.Id;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;

	@PostMapping("/createQuiz")
	public String createQuiz(@RequestParam String category, @RequestParam int numberOfQuestionsInQuiz, @RequestParam String titleOfQuiz) {

		return quizService.createQuiz(category,numberOfQuestionsInQuiz,titleOfQuiz);
	}
	
	@GetMapping("/getListOfQuestionsFromQuizId/{quizId}")
	public List<QuestionWrapper> getListOfQuestionsWithQuizId(@PathVariable int quizId){
		return quizService.getQuizQuestions(quizId);
		
	}

	@PostMapping("/submitQuiz/{quizId}")
	public Integer submitQuiz(@PathVariable Integer quizId,@RequestBody List<Responsee> responses) {
		return quizService.getScoreOfQuiz(quizId,responses);
		
	}
}
