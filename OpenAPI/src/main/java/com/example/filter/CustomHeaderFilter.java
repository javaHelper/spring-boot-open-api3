package com.example.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.example.config.MutableHttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomHeaderFilter implements Filter {

	@Autowired
	private Environment e;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		MutableHttpServletRequest updatedReq = new MutableHttpServletRequest((HttpServletRequest) request);
		
		// Header defaulted to V1 if no Accept-version value found. 
	    if(updatedReq.getHeader("X-Accept-Version") == null) {
	    	log.info("Incoming request has no Accept-version, hence defaulting it to v1");
	    	updatedReq.putHeader("X-Accept-Version", e.getProperty("api.default.version"));
	    }
	    
		// continue execution of other filter chain.
		chain.doFilter(updatedReq, response);
	}
}