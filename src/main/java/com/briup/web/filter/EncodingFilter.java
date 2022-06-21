package com.briup.web.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(value = "/*",initParams = {@WebInitParam(name = "encoding",value = "UTF-8")},dispatcherTypes = {DispatcherType.REQUEST})
public class EncodingFilter implements Filter{
	
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		encoding = filterConfig.getInitParameter("encoding");
		if(encoding==null) {
			encoding = "UTF-8";
		}
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}

}
