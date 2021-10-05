package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long resId;
	private float obtainMarks;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reg_id")
	private User resultUser;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;

	public long getResId() {
		return resId;
	}

	public void setResId(long resId) {
		this.resId = resId;
	}

	public User getResultUser() {
		return resultUser;
	}

	public void setResultUser(User resultUser) {
		this.resultUser = resultUser;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public float getObtainMarks() {
		return obtainMarks;
	}

	public void setObtainMarks(float obtainMarks) {
		this.obtainMarks = obtainMarks;
	}

}