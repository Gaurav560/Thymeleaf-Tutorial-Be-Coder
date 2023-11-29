package com.telusko.service;

import java.util.List;

import com.telusko.exception.CategoryNotFoundException;
import com.telusko.exception.QuestionNotFoundException;
import com.telusko.model.QuestionModel;

public interface QuestionService {

	public List<QuestionModel> getAllQuestions();
	public String deleteQuestion(int qId) throws QuestionNotFoundException;
	public QuestionModel createQuestion(QuestionModel question);
	public QuestionModel updateQuestion(QuestionModel newQuestion,int qId) throws QuestionNotFoundException;
	public List<QuestionModel> getQuestionByCategory(String category) throws CategoryNotFoundException;
}
