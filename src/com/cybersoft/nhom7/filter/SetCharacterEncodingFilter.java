package com.cybersoft.nhom7.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.nhom7.util.Path;



@WebFilter(filterName = "setCharacterEncodingFilter",urlPatterns = Path.ROOT)
public class SetCharacterEncodingFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		req.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("type = text/html, charset = UTF-8");
	}


}
