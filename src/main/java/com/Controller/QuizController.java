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

import com.Entity.Quiz;
import com.Entity.SubCategory;
import com.bean.ResponseBean;
import com.services.QuizService;

@CrossOrigin
@RestController
public class QuizController {
	
	@Autowired
	QuizService service;
	
	@PostMapping("/addQuiz")
	public ResponseBean<Quiz> addQuiz(@RequestBody Quiz quiz)
	{
		ResponseBean<Quiz> res=new ResponseBean<>();
		service.save(quiz);
		res.setData(quiz);
		res.setMessage("Quiz Save Successfully");
		res.setStatus(200);
		return res;
	}
	
	@GetMapping("/getQuiz")
	public ResponseBean<List<Quiz>> getQuiz()
	{
		ResponseBean<List<Quiz>> res=new ResponseBean<>();
		List<Quiz> list=service.getQuiz();
		res.setData(list);
		res.setMessage("List Of All Quiz");
		res.setStatus(200);
		return res;
	}
	
	@DeleteMapping("/quiz/{quizId}")
	public ResponseBean<Quiz> deleteCustomerById(@PathVariable("quizId") Long quizId) {

		ResponseBean<Quiz> res = new ResponseBean<>();

		Long product = service.delete(quizId);

		if (product == null) {
			res.setData(null);
			res.setMessage("Invalid Quiz Id");
			res.setStatus(-1);
		} else {
			//res.setData(product);
			res.setMessage("Quiz Removed");
			res.setStatus(200);
		}
		return res;
	}

}
