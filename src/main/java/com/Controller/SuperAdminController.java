package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.User;
import com.Services.SuperAdminService;
import com.bean.ResponseBean;
@CrossOrigin
@RestController
public class SuperAdminController {
	
	@Autowired
	private SuperAdminService superadminservice;
	
	@GetMapping("/getallusers")
	public ResponseBean<List<User>> getallUserss(){
		ResponseBean<List<User>> res=new ResponseBean<>();
		 
		res.setStatus(200);
		res.setData((List<User>) superadminservice.getUsers());
		res.setMessage("user save");
		return res;
		
	
		
	}
	@GetMapping("/getalladmin")
	public  ResponseBean<List<User>> getalladmin(){
		ResponseBean<List<User>> res=new ResponseBean<>();
		
		res.setStatus(200);
		res.setData((List<User>) superadminservice.getAdmins());
		res.setMessage("user save");
		return res;
		
	
		
	}
	


}
