package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.SubCategory;
import com.Repository.SubCategoryRepository;

@Service
public class SubCategoryService {

	@Autowired
	SubCategoryRepository service;
	
	public void save(SubCategory category)
	{
		service.save(category);
	}
	
	public List<SubCategory> getSubCategory()
	{
		return service.findAll();
	}
	
	public Long delete(Long id)
	{
		service.deleteById(id);
		return id;
	}
}
