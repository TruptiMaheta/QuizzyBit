package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.QuestionsEntity;

@Repository
public interface QuestionsRepository extends JpaRepository<QuestionsEntity, Long>{

}
	