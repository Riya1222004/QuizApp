package com.helloWorld.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class QuizWrapper {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pg")
	@SequenceGenerator(name = "pg",sequenceName = "PSN",allocationSize = 1)
	private Integer id; 
	private String question_title;
	private String option1;
	private String option2;
	private String option3;
	private String option4 ;
	public QuizWrapper(Integer id, String question_title, String option1, String option2, String option3,
			String option4) {
		super();
		this.id = id;
		this.question_title = question_title;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}
}
