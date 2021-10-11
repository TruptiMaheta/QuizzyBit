package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {

}
