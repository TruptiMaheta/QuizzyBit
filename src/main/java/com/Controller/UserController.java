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

import com.Entity.User;
import com.Repository.UserRepository;
import com.Services.UserService;
import com.bean.LoginBean;
import com.bean.ResponseBean;
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
			user.update(user1.getUserId(),token);
			res.setData(user1);
			res.setStatus(200);
			res.setMessage("get Token");
		}
		return res;
	}
	@DeleteMapping("/users/{userId}")
	public ResponseBean<User> deleteCustomerById(@PathVariable("userId") Long userId) {

		ResponseBean<User> res = new ResponseBean<>();

		Long product = service.delete(userId);

		if (product == null) {
			res.setData(null);
			res.setMessage("Invalid User Id");
			res.setStatus(-1);
		} else {
			//res.setData(product);
			res.setMessage("User Removed");
			res.setStatus(200);
		}
		return res;
	}
//	
//	@PutMapping("/userUpdateById/{userId}")
//	public  ResponseBean<User
	
	
	
	@GetMapping("/getuserId/{token}")
	public ResponseBean<Long>getUserIdByToken(@PathVariable("token") String token)
	{
		ResponseBean res=new ResponseBean();
		Long userid=user.findByToken(token).getUserId();
		if (userid == null) {
			res.setData(null);
			res.setMessage("Invalid token");
			res.setStatus(-1);
		} else {
			res.setData(userid);
			res.setMessage("UserId get sucessfully token ");
			res.setStatus(200);
		}
		return res;
	}	
	
	

}



