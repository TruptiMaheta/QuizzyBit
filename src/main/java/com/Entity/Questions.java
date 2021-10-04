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
@Table(name = "questions")
public class Questions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long que_id;
	
	private String questContent;
	@ManyToMany(cascade =CascadeType.ALL)
	@JoinColumn(name="que_cat_id")
	private List<QuizSubCategory> que_cat_id;
	@ManyToMany(cascade =CascadeType.ALL)
	@JoinColumn(name="que_sub_id")
	private List<QuizCategory> que_sub_id;
	public long getQue_id() {
		return que_id;
	}
	public void setQue_id(long que_id) {
		this.que_id = que_id;
	}
	
	
	public List<QuizSubCategory> getQue_cat_id() {
		return que_cat_id;
	}
	public void setQue_cat_id(List<QuizSubCategory> que_cat_id) {
		this.que_cat_id = que_cat_id;
	}
	public List<QuizCategory> getQue_sub_id() {
		return que_sub_id;
	}
	public void setQue_sub_id(List<QuizCategory> que_sub_id) {
		this.que_sub_id = que_sub_id;
	}


	@OneToMany(mappedBy="questions", cascade =CascadeType.ALL)
	private List<Option> option;
	public List<Option> getOption() {
		return option;
	}
	public void setOption(List<Option> option) {
		this.option = option;
	}
	
	@OneToOne(mappedBy="questions", cascade =CascadeType.ALL)
	private Answer answer;
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="quiz_id")
	private Quiz quiz;
	public String getQuestContent() {
		return questContent;
	}
	public void setQuestContent(String questContent) {
		this.questContent = questContent;
	}

	

}
