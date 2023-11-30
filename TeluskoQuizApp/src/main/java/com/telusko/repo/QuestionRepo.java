package com.telusko.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.model.QuestionModel;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionModel, Integer> {

	QuestionModel findByqId(int qId);

	List<QuestionModel> findByQuestionCateogry(String category);

	
	@Query(value = "SELECT * FROM question_model q WHERE q.question_cateogry=:category ORDER BY RANDOM() LIMIT :numberOfQuestionsInQuiz", nativeQuery = true)
	List<QuestionModel> findRandomQuestionsByCategory(String category, int numberOfQuestionsInQuiz);

}
