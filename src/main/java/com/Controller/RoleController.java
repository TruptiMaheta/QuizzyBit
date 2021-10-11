package com.Controller;
import com.Services.RoleService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Role;
import com.Entity.User;

@CrossOrigin
@RestController
public class RoleController {
	
	@Autowired
	RoleService roleService;
	

	@PostMapping("/saveRole")
	public void saveUser(Role role) {
		roleService.save(role);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public int deltebyID(@PathVariable("id") long id)
	{
		roleService.deleteById(id);
		return 1;
	}

}
