package com.spring.register.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.register.domain.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	//email로 사용자 정보를 가져옴
	Optional<Users> findByEmail(String email);
	
	//jpa 공부!
}