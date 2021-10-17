package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.QuestionMaster;

@Repository
public interface QuestionMasterRepository extends JpaRepository<QuestionMaster, Long>{

}
