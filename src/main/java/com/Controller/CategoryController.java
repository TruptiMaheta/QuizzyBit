package com.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.QuizCategory;
import com.Entity.User;
import com.Services.CategoryService;
import com.bean.ResponseBean;
import com.modle.CategoryModel;

@CrossOrigin
@RestController
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@PostMapping("/addCategory")
	public ResponseBean<QuizCategory> addUser(@RequestBody QuizCategory category)
	{
//		QuizCategory category=new QuizCategory();
//		User u=new User();
//		u.setUserId(cat.getUserId());
//		category.setQuizCatName(cat.getQuizCatName());
//		category.setUser(u);
		
		System.out.println(category);
		ResponseBean<QuizCategory> res=new ResponseBean<>();
		service.save(category);
		res.setStatus(200);
		res.setData(category);
		res.setMessage("Category Save");
		//System.out.println(user2.getRole().getRole_id());
		return res;
	}
	
	@GetMapping("/getCategory/{userId}")
	public ResponseBean<List<QuizCategory>> getUsers(@PathVariable long userId)
	{
		ResponseBean<List<QuizCategory>> res=new ResponseBean<>();
		List<QuizCategory> list=service.getCategory(userId).stream().collect(Collectors.toList());
		res.setStatus(200);
		res.setMessage("List Of All Categories");
		res.setData(list);
		return res;
	}
	
	@DeleteMapping("/category/{quizCatId}")
	public ResponseBean<QuizCategory> deleteCustomerById(@PathVariable("quizCatId") Long categoryId) {

		ResponseBean<QuizCategory> res = new ResponseBean<>();

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