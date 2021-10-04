package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.User;
import com.Repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository service;
	
	public void save(User user)
	{
		service.save(user);
	}
	public List<User> get()
	{
		return service.findAll();
	}
	
	/*
	 * public User updateToken(long l,String token) { return service.save(l,token);
	 * }
	 */
}
