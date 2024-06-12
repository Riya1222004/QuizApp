package com.helloWorld.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.helloWorld.dao.QuestionMakerDao;
import com.helloWorld.dao.QuizDao;
import com.helloWorld.entity.Question;
import com.helloWorld.entity.QuizQuestion;
import com.helloWorld.entity.QuizWrapper;
import com.helloWorld.entity.ResponseClass;

@Service
public class QuizMakerService {
	
	@Autowired
	QuestionMakerDao questionMakerDao;
	
	@Autowired
	QuizDao quizDao;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title){
		
		List<Question> questions=quizDao.findRandomQuestionCategory(category,numQ);
		
		QuizQuestion quizQuestion=new QuizQuestion();
		quizQuestion.setTitle(title);
		quizQuestion.setQuestions(questions);
		questionMakerDao.save(quizQuestion);
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}

	public ResponseEntity<List<QuizWrapper>> getAllQuestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<QuizQuestion> q=questionMakerDao.findById(id);
		List<Question> qDBList=q.get().getQuestions();
		List<QuizWrapper> u=new ArrayList<>();
		for(Question f:qDBList) {
			QuizWrapper qWrapper=new QuizWrapper(f.getId(),f.getQuestion_title(),f.getOption1(),f.getOption2(),f.getOption3(),f.getOption4());
			u.add(qWrapper);
		}
		
		return new ResponseEntity<>(u,HttpStatus.OK);
	}

	public ResponseEntity<Integer> submitQuiz(Integer id, List<ResponseClass> responses) {
		// TODO Auto-generated method stub
		Optional<QuizQuestion> q=questionMakerDao.findById(id);
		List<Question> qDBList=q.get().getQuestions();
		int right=0;
		int i=0;
		for(ResponseClass responseClass:responses) {
			String aNString=responseClass.getResponseString();
			if(aNString.equals(qDBList.get(i).getRight_answer())) {
				right++;
			}
			i++;
		}
		return new ResponseEntity<Integer>(right,HttpStatus.OK);
	}

}
