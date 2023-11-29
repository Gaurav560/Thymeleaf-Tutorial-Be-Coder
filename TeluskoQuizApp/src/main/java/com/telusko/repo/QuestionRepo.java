package com.telusko.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telusko.model.QuestionModel;

public interface QuestionRepo extends JpaRepository<QuestionModel, Integer> {

	QuestionModel findByqId(int qId);

	List<QuestionModel> findByQuestionCateogry(String category);

}
