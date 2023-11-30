package com.telusko.service;

import java.util.List;

import com.telusko.model.QuestionWrapper;
import com.telusko.model.Responsee;

public interface QuizService {

	String createQuiz(String category, int numberOfQuestionsInQuiz, String titleOfQuiz);

	List<QuestionWrapper> getQuizQuestions(int quizId);

	Integer getScoreOfQuiz(Integer quizId, List<Responsee> responses);

	

}
