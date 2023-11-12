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
@ToString
@Setter
@Getter
@Table
public class Athletedetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ath_id;
	private String ath_Name;
	private Float ath_Height;
	private String ath_Speciality;
	private Integer ath_Age;
	private Float ath_Weight;
	
}
