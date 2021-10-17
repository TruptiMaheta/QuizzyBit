package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.Entity.OptionEntity;
import com.Entity.QuestionMaster;

@Entity
@Table(name="Questions")
public class QuestionsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Que_id;
	public String Questions;
	public String opt1;
	public String opt2;
	public String opt3;
	public String opt4;
	public String correct;
	
	 @OneToOne(mappedBy = "que", cascade = CascadeType.ALL)
	  private QuestionMaster quemas;
	  
	  @OneToOne(mappedBy = "que", cascade = CascadeType.ALL)
	  private OptionEntity opt;
	
	public QuestionsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getQue_id() {
		return Que_id;
	}
	public QuestionsEntity(int que_id, String questions, String opt1, String opt2, String opt3, String opt4,
			String correct) {
		super();
		Que_id = que_id;
		Questions = questions;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.correct = correct;
	}
	public void setQue_id(int que_id) {
		Que_id = que_id;
	}
	public String getQuestions() {
		return Questions;
	}
	public void setQuestions(String questions) {
		Questions = questions;
	}
	public String getOpt1() {
		return opt1;
	}
	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}
	public String getOpt2() {
		return opt2;
	}
	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}
	public String getOpt3() {
		return opt3;
	}
	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}
	public String getOpt4() {
		return opt4;
	}
	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	
}
