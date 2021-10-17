package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.OptionEntity;

@Repository
public interface OptionRepository extends JpaRepository<OptionEntity, Long>{

}
