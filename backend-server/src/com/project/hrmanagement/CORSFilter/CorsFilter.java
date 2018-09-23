package com.project.hrmanagement.CORSFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CorsFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(CorsFilter.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requestToUse = (HttpServletRequest) request;
		HttpServletResponse responseToUse = (HttpServletResponse) response;
		
		responseToUse.addHeader("Access-Control-Allow-Origin", "*");
		responseToUse.addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
		chain.doFilter(requestToUse, responseToUse);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		logger.info("initializing CORS Filter...");
	}

}
