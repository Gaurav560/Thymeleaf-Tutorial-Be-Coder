package com.telusko.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWrapper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qId;

	@NotEmpty(message = "question space cant be empty")
	private String question;
	@NotEmpty(message = "option space cant be empty")
	private String optionAnswer1;
	@NotEmpty(message = "option space cant be empty")
	private String optionAnswer2;
	@NotEmpty(message = "option space cant be empty")
	private String optionAnswer3;
	@NotEmpty(message = "option space cant be empty")
	private String optionAnswer4;
}
