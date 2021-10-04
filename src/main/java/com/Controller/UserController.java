package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.User;
import com.bean.CustomerBean;
import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.services.UserService;
@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserService service;
	
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
		// CustomerBean c=new CustomerBean();
		User customer1 = service
		if (customer1 == null) {
			res.setStatus(-1);
			res.setData(customer1);
			res.setMessage("Invalid Credentials");
		} else {
			String token = tokenGenerator.generateToken();
			customer1.setToken(token);
			customerDao.updateToken(customer1.getCustomerId(), token);
			res.setData(customer1);
			res.setStatus(200);
			res.setMessage("authentication done");
		}

		return res;
	}

}
