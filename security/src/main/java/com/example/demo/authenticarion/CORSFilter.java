package com.example.demo.authenticarion;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.classmate.Filter;

public class CORSFilter  {

	public void init(FilterConfig filterConfig) throws ServletException { }

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		
		HttpServletResponse response = (HttpServletResponse) servletResponse;
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, X-Requested-With, Authorization");
	    response.setHeader("Access-Control-Expose-Headers", "Authorization");
	    filterChain.doFilter(servletRequest, response);
	}

	public void destroy() {	}

}
