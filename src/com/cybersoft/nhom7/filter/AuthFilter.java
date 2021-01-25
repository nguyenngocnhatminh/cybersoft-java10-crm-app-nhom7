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
import javax.servlet.http.HttpSession;

import com.cybersoft.nhom7.dto.UserDto;
import com.cybersoft.nhom7.util.Path;

@WebFilter(filterName = "authFilter", urlPatterns = Path.ROOT)
public class AuthFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getServletPath();
		
		HttpSession session = req.getSession();
		UserDto dto = (UserDto)session.getAttribute("USER_LOGIN");
		
		if(path.startsWith(Path.LOGIN) || path.startsWith(Path.SIGNUP) || path.startsWith(Path.ASSETS))
		{
			chain.doFilter(request, response);
			return;
		}
		if(dto == null)
		{
			resp.sendRedirect(req.getContextPath()+ Path.LOGIN);
			return;
		}
		
		chain.doFilter(request, response);
	}
}
