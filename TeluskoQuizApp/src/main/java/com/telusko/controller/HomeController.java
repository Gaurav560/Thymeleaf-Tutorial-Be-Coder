package com.telusko.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.exception.CategoryNotFoundException;
import com.telusko.exception.QuestionNotFoundException;
import com.telusko.model.QuestionModel;
import com.telusko.service.QuestionService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/question")
public class HomeController {

	@Autowired
	QuestionService questionService;

	// controller method for getting all questions
	@GetMapping("/allQuestions")
	public List<QuestionModel> getAllQuestions() 
	{
		return questionService.getAllQuestions();
	}

//controller method for creating a question
	@PostMapping("/createQuestion")
	public QuestionModel createQuestion(@Valid @RequestBody QuestionModel question) 
	{
		return questionService.createQuestion(question);
	}

//Controller method for deleting a question 
	@DeleteMapping("/deleteQuestions/{qId}")
	public String deleteQuestion(@PathVariable int qId) throws QuestionNotFoundException 
	{
		questionService.deleteQuestion(qId);
		return "question deleted";
	}

	// controller method for updating a question
	@PutMapping("/updateQuestion/{qId}")
	public QuestionModel updateQuestion(@RequestBody QuestionModel question, @PathVariable int qId)
			throws QuestionNotFoundException 
	{
		return questionService.updateQuestion(question, qId);
	}
	
	//controller method for getting details by Category
	@GetMapping("/getQuestionsByCateogry/{category}")
	public List<QuestionModel> getQuestionsByCategory(@PathVariable String category) throws CategoryNotFoundException
	{
		return questionService.getQuestionByCategory(category);
		
		
	}

}
