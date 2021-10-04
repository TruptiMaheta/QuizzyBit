package com.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.User;

import com.Repository.UserRepository;
import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.services.UserService;
import com.util.TokenGenerator;
@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository user;
	
	@Autowired
	private TokenGenerator tokenGenerator;
	
	
	@PostMapping("/addUser")
	public ResponseBean<User> addUser(@RequestBody User user)
	{
		ResponseBean<User> res=new ResponseBean<>();
		service.save(user);
		res.setStatus(200);
		res.setData(user);
		res.setMessage("user save");
		return res;
	}
	
	@GetMapping("/getUsers")
	public ResponseBean<List<User>> getUsers()
	{
		ResponseBean<List<User>> res=new ResponseBean<>();
		List<User> list=service.get();
		res.setStatus(200);
		res.setMessage("List Of All Users");
		res.setData(list);
		return res;
	}
	
	@PostMapping("/authenticate")
	public ResponseBean<User> authenticate(@RequestBody LoginBean login) {
		ResponseBean<User> res = new ResponseBean<>();
		User user1 = user.findByEmailAndPassword(login.getEmail(), login.getPassword());
		if (user1 == null) {
			res.setStatus(-1);
			res.setData(user1);
			res.setMessage("Invalid User");
		}
		else
		{
			String token=tokenGenerator.generateToken();
			user1.setToken(token);
			user.update(user1.getUser_id(),token);
			res.setData(user1);
			res.setStatus(200);
			res.setMessage("get Token");
		}
		return res;
	}	
	
	@GetMapping("/forgetPassword")
	public ResponseBean<User> forget(@RequestBody LoginBean login)
	{
		ResponseBean<User> res=new ResponseBean<>();
		User user1=user.findByEmail(login.getEmail());
		if(user1==null)
		{
			res.setStatus(-1);
			res.setData(user1);
			res.setMessage("Invalid User");
		}
		else
		{
			
		}
	}

}
