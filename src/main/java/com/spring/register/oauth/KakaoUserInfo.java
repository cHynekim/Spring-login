package com.spring.register.oauth;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class KakaoUserInfo implements OAuth2UserInfo{
	
	private Map<String, Object> attributes;
	
	@Override
	public String getProviderId() {
		// TODO Auto-generated method stub
		return attributes.get("id").toString();
	}

	@Override
	public String getProvider() {
		// TODO Auto-generated method stub
		return "kakao";
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return (String)((Map) attributes.get("kakao_account")).get("email");
	}

}
