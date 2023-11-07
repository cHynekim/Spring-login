package com.spring.register.oauth;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GoogleUserInfo implements OAuth2UserInfo{

	private Map<String, Object> attributes;
	
	@Override
	public String getProviderId() {
		// TODO Auto-generated method stub
		return (String)attributes.get("sub");
	}

	@Override
	public String getProvider() {
		// TODO Auto-generated method stub
		return "google";
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return (String)attributes.get("email");
	}
	
}
