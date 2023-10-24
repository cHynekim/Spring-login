package com.spring.register.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
	@Email
	@NotEmpty(message = "이메일 입력 ㅂㅌ")
	private String email;
	
	@NotEmpty(message = "비밀번호 입력 ㅂㅌ")
	private String password;
	
	@NotEmpty(message = "비번 확인 입력 ㅂㅌ")
	private String passwordCheck;
}
