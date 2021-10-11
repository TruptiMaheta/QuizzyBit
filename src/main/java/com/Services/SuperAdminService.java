package com.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.User;
import com.Repository.UserRepository;

@Service
public class SuperAdminService {

	
	@Autowired
	private UserRepository userRepo;
	private List<User>users;
	private List<User>admins;
	private List<User> allusers;
	public List<User> getUsers() {
		this.users = userRepo.findAll().stream().filter(user->user.getRole().getRole_id()==3).toList();
		//this.users=userRepo.findAll();
		return users;
	}

	

	public List<User> getAdmins() {//not needed
		this.admins =userRepo.findAll().stream().filter(user->user.getRole().getRole_id()==2).toList();
		return admins;
	}

	

	public void  findallusers() 
	{
		allusers=userRepo.findAll();
		
		
	}
	
	 

}
