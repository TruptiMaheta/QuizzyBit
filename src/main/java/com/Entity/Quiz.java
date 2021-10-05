package com.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long quiz_id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "que_cat_id")
	private QuizSubCategory que_cat_id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "que_sub_id")
	private QuizCategory que_sub_id;

	private int no_que;
	private int pointPerQue;
	private boolean isNegative;
	private float deuctionOf;
	private boolean isActive;
	private Date startDate;
	private Date endDate;
	private boolean isPublic;
	private String code;
	private float marks;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "quiz_user")
	private List<User> quizUser;

	public List<User> getQuizUser() {
		return quizUser;
	}

	public void setQuizUser(List<User> quizUser) {
		this.quizUser = quizUser;
	}

	public long getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(long quiz_id) {
		this.quiz_id = quiz_id;
	}

	public QuizSubCategory getQue_cat_id() {
		return que_cat_id;
	}

	public void setQue_cat_id(QuizSubCategory que_cat_id) {
		this.que_cat_id = que_cat_id;
	}

	public QuizCategory getQue_sub_id() {
		return que_sub_id;
	}

	public void setQue_sub_id(QuizCategory que_sub_id) {
		this.que_sub_id = que_sub_id;
	}

	public int getNo_que() {
		return no_que;
	}

	public void setNo_que(int no_que) {
		this.no_que = no_que;
	}

	public int getPointPerQue() {
		return pointPerQue;
	}

	public void setPointPerQue(int pointPerQue) {
		this.pointPerQue = pointPerQue;
	}

	public boolean isNegative() {
		return isNegative;
	}

	public void setNegative(boolean isNegative) {
		this.isNegative = isNegative;
	}

	public float getDeuctionOf() {
		return deuctionOf;
	}

	public void setDeuctionOf(float deuctionOf) {
		this.deuctionOf = deuctionOf;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

}
