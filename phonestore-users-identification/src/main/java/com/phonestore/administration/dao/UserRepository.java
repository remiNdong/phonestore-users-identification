package com.phonestore.administration.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phonestore.administration.domain.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
	

}