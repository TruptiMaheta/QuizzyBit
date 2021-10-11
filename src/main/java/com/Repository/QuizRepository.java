package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
