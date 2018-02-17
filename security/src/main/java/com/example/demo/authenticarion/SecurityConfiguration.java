package com.example.demo.authenticarion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	private static String REALM="MY_TEST_REALM";
	
	@Autowired 
	private AuthenticationEntryPoint _authentication;
	
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)throws Exception{
		auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("tom").password("123").roles("User");
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/v1/**").hasRole("USER")
		//.anyRequest().authenticated()
		.and()
		.httpBasic()
		.authenticationEntryPoint(_authentication)
		.realmName(REALM)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.STATELESS);
		
	}

}
