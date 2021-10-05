package com.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quiz_Category")
public class QuizCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long quizCatId;
	private String quizCatName;

	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "UserId")
	private User user;

	@OneToMany(mappedBy = "que_cat_id", cascade = CascadeType.ALL)
	private List<Quiz> quiz;

	@OneToMany(mappedBy = "que_cat_id", cascade = CascadeType.ALL)
	private List<Questions> questions;

	

	public long getQuizCatId() {
		return quizCatId;
	}

	public void setQuizCatId(long quizCatId) {
		this.quizCatId = quizCatId;
	}

	public String getQuizCatName() {
		return quizCatName;
	}

	public void setQuizCatName(String quizCatName) {
		this.quizCatName = quizCatName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Quiz> getQuiz() {
		return quiz;
	}

	public void setQuiz(List<Quiz> quiz) {
		this.quiz = quiz;
	}

}