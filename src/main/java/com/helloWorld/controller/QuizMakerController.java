package com.helloWorld.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helloWorld.entity.Question;
import com.helloWorld.entity.QuizWrapper;
import com.helloWorld.entity.ResponseClass;
import com.helloWorld.service.QuizMakerService;

@RestController
@RequestMapping("quiz")
public class QuizMakerController {
	
	@Autowired
	QuizMakerService quizMakerService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title) {
		return quizMakerService.createQuiz(category,numQ,title);
	}
	
	@GetMapping("get/{id}")
    public ResponseEntity<List<QuizWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizMakerService.getAllQuestions(id);
    }
	
	@PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<ResponseClass> responses) {
        return quizMakerService.submitQuiz(id, responses); // Assuming submitQuiz method exists in the service
    }
}
