package com.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Category;
import com.Entity.User;
import com.Repository.CategoryRepository;
import com.bean.ResponseBean;
import com.services.CategoryService;

@CrossOrigin
@RestController
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@PostMapping("/addCategory")
	public ResponseBean<Category> addUser(@RequestBody Category category)
	{
		ResponseBean<Category> res=new ResponseBean<>();
		service.save(category);
		res.setStatus(200);
		res.setData(category);
		res.setMessage("Category Save");
		//System.out.println(user2.getRole().getRole_id());
		return res;
	}
	
	@GetMapping("/getCategory")
	public ResponseBean<List<Category>> getUsers()
	{
		ResponseBean<List<Category>> res=new ResponseBean<>();
		List<Category> list=service.getCategory();
		res.setStatus(200);
		res.setMessage("List Of All Categories");
		res.setData(list);
		return res;
	}
	
	@DeleteMapping("/category/{categoryId}")
	public ResponseBean<Category> deleteCustomerById(@PathVariable("categoryId") Long categoryId) {

		ResponseBean<Category> res = new ResponseBean<>();

		Long product = service.delete(categoryId);

		if (product == null) {
			res.setData(null);
			res.setMessage("Invalid Category Id");
			res.setStatus(-1);
		} else {
			//res.setData(product);
			res.setMessage("Category Removed");
			res.setStatus(200);
		}
		return res;
	}
}
