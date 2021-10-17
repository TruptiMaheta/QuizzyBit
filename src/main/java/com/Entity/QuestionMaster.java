package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.Entity.QuestionsEntity;

@Entity
@Table(name="QuestionMaster")
public class QuestionMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Quemaster_id;
	
	@OneToOne()
    @JoinColumn(name = "Que_id")
	private QuestionsEntity que;

	public long getQuemaster_id() {
		return Quemaster_id;
	}

	public void setQuemaster_id(long quemaster_id) {
		Quemaster_id = quemaster_id;
	}

	public QuestionsEntity getQue() {
		return que;
	}

	public void setQue(QuestionsEntity que) {
		this.que = que;
	}
	
	
}
