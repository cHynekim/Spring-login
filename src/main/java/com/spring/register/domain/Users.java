package com.spring.register.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity	//table
@Builder	//CREATE, UPDATE 자동
@Getter	//컬럼을 받아 사용하게 함
@NoArgsConstructor	//파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor	//모든 필드 값을 파라미터로 받는 생성자를 생성
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment 사용
	@Column(name = "id", updatable = false)
	private Long id;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "provider")
	private String provider;
	
	@Column(name = "provider_id")
	private String provider_id;
	
	@Column(name = "social_id")
	private String social_id;
}
