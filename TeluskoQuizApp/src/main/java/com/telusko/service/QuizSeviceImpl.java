package com.telusko.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.model.QuestionModel;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Quiz;
import com.telusko.model.Responsee;
import com.telusko.repo.QuestionRepo;
import com.telusko.repo.QuizRepo;

@Service
public class QuizSeviceImpl implements QuizService {

	@Autowired
	private QuizRepo quizRepo;

	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public String createQuiz(String category, int numberOfQuestionsInQuiz, String titleOfQuiz) {

		List<QuestionModel> questions = questionRepo.findRandomQuestionsByCategory(category, numberOfQuestionsInQuiz);
		Quiz quiz = new Quiz();
		quiz.setQuizTitle(titleOfQuiz);
		quiz.setQuestions(questions);
		quizRepo.save(quiz);
		return "success";
	}

	@Override
	public List<QuestionWrapper> getQuizQuestions(int quizId) {

		Optional<Quiz> quiz = quizRepo.findById(quizId);
		List<QuestionModel> questionsFromDb = quiz.get().getQuestions();
		List<QuestionWrapper> questionForUsers = new ArrayList<>();

		for (QuestionModel q : questionsFromDb) {
			QuestionWrapper qw = new QuestionWrapper(q.getQId(), q.getQuestion(), q.getOptionAnswer1(),
					q.getOptionAnswer2(), q.getOptionAnswer3(), q.getOptionAnswer4());
			questionForUsers.add(qw);
		}

		return questionForUsers;
	}

	@Override
	public Integer getScoreOfQuiz(Integer quizId, List<Responsee> responses) {

		Quiz quiz = quizRepo.findById(quizId).get();
	
		List<QuestionModel> questions = quiz.getQuestions();
		int rightAnswer = 0;
		int i = 0;
		for (Responsee r:responses) 
		{
	
			if (r.getResponseValue().equals(questions.get(i).getCorrectAnswer())) {
				
				rightAnswer++;
				
			}
			i++;
		}

		return rightAnswer;
	}

}
