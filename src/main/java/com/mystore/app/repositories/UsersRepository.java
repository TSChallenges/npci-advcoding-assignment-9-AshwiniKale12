package com.mystore.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mystore.app.entity.Users;

@EnableJpaRepositories
public interface UsersRepository extends JpaRepository<Users, Long>{
	
	Users findByUsername(String username);

}
