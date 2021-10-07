package com.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	private String name;
	private String email;
	private String password;
	private String token;
	
	@ManyToOne()
	
	@JoinColumn(name="role_id") 
	private Role role;
	
	/*
	 * @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	 * //@PrimaryKeyJoinColumn private Set<Category> category;
	 */
	
	public Role getRole() { return role; }
	
	public void setRole(Role role) { this.role = role; }
	
	

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/*
	 * public Set<Category> getCategory() { return category; }
	 * 
	 * public void setCategory(Set<Category> category) { this.category = category; }
	 */
	
	
	
	
	
	
}
