package com.Entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	private long user_id;
	private String name;
	private String email;
	private String password;
	private String profile_pic;
	

	
	 @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	 private Set<QuizCategory> quizCategories;

	 @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	 private Set<QuizSubCategory> quizSubCategories;
	 
	
	public Set<QuizSubCategory> getQuizSubCategories() {
		return quizSubCategories;
	}

	public void setQuizSubCategories(Set<QuizSubCategory> quizSubCategories) {
		this.quizSubCategories = quizSubCategories;
	}

	public Set<QuizCategory> getQuizCategories() {
		return quizCategories;
	}

	public void setQuizCategories(Set<QuizCategory> quizCategories) {
		this.quizCategories = quizCategories;
	}

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

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="role_id")
	private Role role;



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToMany(mappedBy="quizUser")
	private List<Quiz>quiz;

}
