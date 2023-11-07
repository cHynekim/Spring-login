package com.spring.register.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.spring.register.service.PrincipalOauth2UserService;
import com.spring.register.service.UserDetailService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {
	private final UserDetailService userService;
	private final PrincipalOauth2UserService principalOauth2UserService;
	
	//Security 기능 비활 -> 이미지, css 보존 위함
	@Bean
	public WebSecurityCustomizer configure() {
		return (web) -> web.ignoring().requestMatchers("/static/**", "/error");
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http
				.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
						.requestMatchers("/login", "/signup", "/user").permitAll()
						.anyRequest().authenticated())
				//login 설정
				.formLogin(formLogin -> {
					formLogin
						.loginPage("/login")
						.usernameParameter("email")
						.defaultSuccessUrl("/");
				})
				//logout 설정
				.logout(logout -> {
					logout
						.logoutSuccessUrl("/login")
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID");
				})
				
				//oauth2 login : google
				.oauth2Login(oauth2Login -> oauth2Login
						.loginPage("/login")
						.defaultSuccessUrl("/")
						.userInfoEndpoint(userInfo -> userInfo.userService(principalOauth2UserService)))
				//csrf 비활성화
				.csrf(csrf -> csrf.disable())
				
				.build();
	}
	
	//Id, pw 인증
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, 
			BCryptPasswordEncoder bCryptPasswordEncoder,
			UserDetailService userDetailService) throws Exception{
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userService)
				.passwordEncoder(bCryptPasswordEncoder)
				.and()
				.build();
	}
}