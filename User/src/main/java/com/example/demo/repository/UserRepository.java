package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{


	@Query("SELECT u FROM User u WHERE u.id  = :id")  
	User searchUserId(@Param("id") int id);
	
}
