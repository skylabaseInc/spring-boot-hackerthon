package com.example.demo.authenticarion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
	
	public void commence (final HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authEx ) 
	throws IOException, ServletException{
		response.addHeader("WWW-Authentication","Basic realm="+getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter Writer = response.getWriter();
		PrintWriter writer;
		Writer.println("HTTP Status 401 -"+authEx.getMessage());
	}
	
	@Override
	public void afterPropertiesSet() throws Exception{
		setRealmName ("Spring Security Applicaion");
		super.afterPropertiesSet();
	}

}
