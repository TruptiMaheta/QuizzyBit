
 package com.Repository;
 
 import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import
 org.springframework.stereotype.Repository;

import com.Entity.Role;
import com.Entity.User;
 
 @Repository
 public interface UserRepository extends JpaRepository<User,
 Long>{
 
	
	public User findByEmailAndPassword(String email,String password);

	@Modifying
	@Transactional
	@Query("update User set token= :token where user_id = :user_id")
	public void update(@Param("user_id") Long id,@Param("token") String token);
	
	public User findByEmail(String email);	
	
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("insert into User(user_id,name,email,password,role) values(:user_id,:name,:email,:password,:role)"
	 * ) public void insert();
	 */
	
 }
