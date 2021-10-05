package com.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmailAndPassword(String email,String password);

	@Modifying
	@Transactional
	@Query("update User set token= :token where userId = :userId")
	public void update(@Param("userId") Long id,@Param("token") String token);
	
	public User findByEmail(String email);

}
