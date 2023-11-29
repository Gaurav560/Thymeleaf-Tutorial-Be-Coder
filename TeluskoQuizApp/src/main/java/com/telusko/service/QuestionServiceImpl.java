package com.telusko.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.exception.CategoryNotFoundException;
import com.telusko.exception.QuestionNotFoundException;
import com.telusko.model.QuestionModel;
import com.telusko.repo.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

	// injecting questionRepo object into service class
	@Autowired
	private QuestionRepo questionRepo;

//for getting all questions 
	@Override
	public List<QuestionModel> getAllQuestions() {

		return questionRepo.findAll();
	}

	// for deleting a question
	@Override
	public String deleteQuestion(int qId) throws QuestionNotFoundException {

		if (questionRepo.existsById(qId)) {
			questionRepo.deleteById(qId);
			return "question deleted";
		} else {
			throw new QuestionNotFoundException("question not found with id" + qId);
		}

	}

	// for creating a question
	@Override
	public QuestionModel createQuestion(QuestionModel question) {
		return questionRepo.save(question);
	}

	// for updating a question
	@Override
	public QuestionModel updateQuestion(QuestionModel newQuestion, int qId) throws QuestionNotFoundException {

		if (questionRepo.existsById(qId)) {
			QuestionModel existingQuestion = questionRepo.findByqId(qId);
			existingQuestion.setCorrectAnswer(newQuestion.getCorrectAnswer());
			existingQuestion.setOptionAnswer1(newQuestion.getOptionAnswer1());
			existingQuestion.setOptionAnswer1(newQuestion.getOptionAnswer1());
			existingQuestion.setOptionAnswer1(newQuestion.getOptionAnswer1());
			existingQuestion.setOptionAnswer1(newQuestion.getOptionAnswer1());
			existingQuestion.setQuestion(newQuestion.getQuestion());
			existingQuestion.setQuestionCateogry(newQuestion.getQuestionCateogry());
			existingQuestion.setQuestionDifficultyLevel(newQuestion.getQuestionDifficultyLevel());

			return questionRepo.save(existingQuestion);

		} else {
			throw new QuestionNotFoundException("question not found with id :: " + qId);
		}

	}

	@Override
	public List<QuestionModel> getQuestionByCategory(String category) throws CategoryNotFoundException {
		if (questionRepo.findByQuestionCateogry(category).isEmpty()) {
			throw new CategoryNotFoundException("oops!  this "+ category +" category does not exists");
		} else {
			return questionRepo.findByQuestionCateogry(category);
		}

	}

}
