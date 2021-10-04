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
import javax.persistence.Table;

@Entity
@Table(name = "quiz_SubCat")
public class QuizSubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subCatId;
	private String subCatName;
	@ManyToOne(targetEntity = QuizCategory.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Quiz_Cat")
	private QuizCategory cat;

	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	public long getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(long subCatId) {
		this.subCatId = subCatId;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public QuizCategory getCat() {
		return cat;
	}

	public void setCat(QuizCategory cat) {
		this.cat = cat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy="que_sub_id",cascade =CascadeType.ALL)
	private List<Quiz>quiz;
	
	@ManyToMany(mappedBy="que_sub_id",cascade =CascadeType.ALL)
	private List<Questions>questions;

}
