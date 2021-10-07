package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Category;
import com.Repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository service;
	
	public void save(Category category)
	{
		service.save(category);
	}
	
	public List<Category> getCategory()
	{
		return service.findAll();
	}
	
	public Long delete(Long id)
	{
		service.deleteById(id);
		return id;
	}
}
