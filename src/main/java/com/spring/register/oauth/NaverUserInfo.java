package com.spring.register.oauth;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NaverUserInfo implements OAuth2UserInfo{

	private Map<String, Object> attributes;
	
	@Override
	public String getProviderId() {
		// TODO Auto-generated method stub
		return (String)attributes.get("id");
	}

	@Override
	public String getProvider() {
		// TODO Auto-generated method stub
		return "naver";
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return (String)attributes.get("email");
	}
}
