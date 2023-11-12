package com.ineuron.ai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
public class Doctor {

@Id()
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doc_Id;
	private String doc_Name;
	private String doc_Speciality;
	private Integer doc_Exp;
	private Float doc_Salary;
	
	
}
