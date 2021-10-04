/*
 * package com.Entity;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.ManyToOne; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "quiz_Category") public class QuizCategory {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) long quizCatId; String
 * quizCatName;
 * 
 * @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
 * 
 * @JoinColumn(name="UserId") User user; public long getQuizCatId() { return
 * quizCatId; } public void setQuizCatId(long quizCatId) { this.quizCatId =
 * quizCatId; } public String getQuizCatName() { return quizCatName; } public
 * void setQuizCatName(String quizCatName) { this.quizCatName = quizCatName; }
 * public User getUser() { return user; } public void setUser(User user) {
 * this.user = user; }
 * 
 * }
 */