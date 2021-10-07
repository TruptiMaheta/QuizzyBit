package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Quiz;
import com.Repository.QuizRepository;

@Service
public class QuizService {

	@Autowired
	QuizRepository service;
	
	public void save(Quiz bean)
	{
		service.save(bean);
	}
	
	public List<Quiz> getQuiz()
	{
		return service.findAll();
	}
	
	public Long delete(Long id)
	{
		service.deleteById(id);
		return id;
	}
}


