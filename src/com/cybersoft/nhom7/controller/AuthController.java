package com.cybersoft.nhom7.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybersoft.nhom7.dto.UserDto;
import com.cybersoft.nhom7.service.AuthService;
import com.cybersoft.nhom7.service.RoleService;
import com.cybersoft.nhom7.service.UserService;
import com.cybersoft.nhom7.util.Path;
import com.cybersoft.nhom7.util.Url;

@WebServlet(name = "authController" , urlPatterns = {Path.LOGIN,Path.LOGOUT,Path.SIGNUP})
public class AuthController extends HttpServlet{
	AuthService service;
	
	public AuthController()
	{
		service = new AuthService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch(action)
		{
		case Path.LOGIN:
			req.getRequestDispatcher(Url.URL_LOGIN).forward(req, resp);
			break;
		case Path.SIGNUP:
			req.getRequestDispatcher(Url.URL_SIGNUP).forward(req, resp);
			break;
		case Path.LOGOUT:
			HttpSession session = req.getSession();
			session.removeAttribute("USER_LOGIN");
			resp.sendRedirect(req.getContextPath() + Path.LOGIN);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserDto dto;
		
		switch(action)
		{
		case Path.LOGIN:
			dto = service.Login(username, password);
			if(dto == null)
			{
				req.setAttribute("message", "Đăng nhập không thành công");
				req.getRequestDispatcher(Url.URL_LOGIN).forward(req, resp);
				return;
			}
			HttpSession session = req.getSession();
			session.setAttribute("USER_LOGIN", dto);
			resp.sendRedirect(req.getContextPath() + Path.HOME);
			break;
		case Path.SIGNUP:
			String email = req.getParameter("email");
			dto = new UserDto();
			dto.setUsername(username);
			dto.setPassword(password);
			dto.setEmail(email);
			int result = service.SignUp(dto);
			if(result < 1)
			{
				if(result == -2)
					req.setAttribute("message", "Username hoặc email đã tồn tại");
				else req.setAttribute("message", "Đăng ký không thành công");
				req.getRequestDispatcher(Url.URL_SIGNUP).forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + Path.LOGIN);
			break;
		}
	}
}
