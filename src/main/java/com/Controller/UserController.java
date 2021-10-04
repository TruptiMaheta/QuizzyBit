package com.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Role;
import com.Repository.RoleRepository;

@RestController
public class UserController {
	
	@Autowired 
	RoleRepository role;
	
	@DeleteMapping("/delete/{id}")
	public int deltebyID(@PathVariable("id") long id)
	{
		Optional<Role> role1=role.findById(id);
		
		role.deleteById(id);
		return 1;
	}
	
	

}
