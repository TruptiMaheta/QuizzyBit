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
@Table(name="option")
public class OptionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long opt_id;
	
	@OneToOne()
    @JoinColumn(name = "Que_id")
	private QuestionsEntity que;

	public long getOpt_id() {
		return opt_id;
	}

	public void setOpt_id(long opt_id) {
		this.opt_id = opt_id;
	}

	public QuestionsEntity getQue() {
		return que;
	}

	public void setQue(QuestionsEntity que) {
		this.que = que;
	}
	
	

}
