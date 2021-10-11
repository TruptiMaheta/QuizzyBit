package com.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Role;

import com.Repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleService;
	
	
	public void save(Role role)
	{
		roleService.save(role);
	}


	public void deleteById(long id) {
		roleService.deleteById(id);
		// TODO Auto-generated method stub
		
	}

}
