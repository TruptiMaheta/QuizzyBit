package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Entity.QuizCategory;

public interface CategoryRepository extends JpaRepository<QuizCategory, Long> {
	@Query(value = "select * from quiz_category where user_id=:userId",nativeQuery = true)
	public List<QuizCategory>findByuser(@Param("userId")Long userId);

}
