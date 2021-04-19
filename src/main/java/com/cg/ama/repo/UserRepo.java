package com.cg.ama.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.ama.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{
	boolean existsByUserName(String userName);
	UserEntity findByUserName(String userName);
}
