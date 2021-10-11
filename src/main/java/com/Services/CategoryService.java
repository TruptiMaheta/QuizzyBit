package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.QuizCategory;
import com.Repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository service;
	
	public void save(QuizCategory category)
	{
		service.save(category);
	}
	
	public List<QuizCategory> getCategory(long userId)
	{
		return service.findByuser(userId);
	}
	
	public Long delete(Long id)
	{
		service.deleteById(id);
		return id;
	}
}