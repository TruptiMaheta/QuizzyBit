package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long>{

}
