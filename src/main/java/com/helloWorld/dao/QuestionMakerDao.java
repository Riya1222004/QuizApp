package com.helloWorld.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helloWorld.entity.QuizQuestion;

public interface QuestionMakerDao extends JpaRepository<QuizQuestion, Integer>  {

}
