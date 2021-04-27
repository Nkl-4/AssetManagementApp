package com.cg.ama.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.ama.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{
	
	//method to check whether a user name exists
	boolean existsByUserName(String userName);
	
	//method to find user by user name
	UserEntity findByUserName(String userName);
}
