package com.cybersoft.nhom7.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.nhom7.dto.RoleDto;
import com.cybersoft.nhom7.dto.UserDto;
import com.cybersoft.nhom7.service.RoleService;
import com.cybersoft.nhom7.service.UserService;
import com.cybersoft.nhom7.util.Path;
import com.cybersoft.nhom7.util.Url;

@WebServlet(name = "userController", urlPatterns = {Path.USER_INDEX,Path.USER_ADD,Path.USER_EDIT,Path.USER_DELETE})
public class UserController extends HttpServlet{
	UserService userservice;
	RoleService roleservice;
	
	public UserController() {
		userservice = new UserService();
		roleservice = new RoleService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		List<RoleDto> roledtos;
		int id;
		switch(action)
		{
		case Path.USER_INDEX:
			List<UserDto> userdtos = userservice.getAllUsers();
			req.setAttribute("users", userdtos);
			req.getRequestDispatcher(Url.URL_USER_INDEX).forward(req, resp);
			break;
		case Path.USER_ADD:
			roledtos = roleservice.getAllRoles();
			req.setAttribute("roles", roledtos);
			req.getRequestDispatcher(Url.URL_USER_ADD).forward(req, resp);;
			break;
		case Path.USER_EDIT:
			id = Integer.parseInt(req.getParameter("id"));
			UserDto user = userservice.getUserById(id);
			roledtos = roleservice.getAllRoles();
			req.setAttribute("user", user);
			req.setAttribute("roles", roledtos);
			req.getRequestDispatcher(Url.URL_USER_EDIT).forward(req, resp);
			break;
		case Path.USER_DELETE:
			id = Integer.parseInt(req.getParameter("id"));
			if(userservice.delete(id) < 1)
			{
				req.setAttribute("message", "Xóa không thành công");
			}
			resp.sendRedirect(req.getContextPath()+Path.USER_INDEX);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getServletPath();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email 	= req.getParameter("email");
		String fullname	= req.getParameter("fullname");
		String address	= req.getParameter("address");
		String phone	= req.getParameter("phone");
		int	roleid		= Integer.parseInt(req.getParameter("roleid"));
		List<RoleDto> roledtos;
		
		UserDto dto = new UserDto(username,password,email,address,fullname,phone,roleid);
		dto.setAvatar("/assets/images/avatars/default.jpg");
		int result;
		switch(action)
		{
		case Path.USER_ADD:
			result = userservice.save(dto);
			if(result <1)
			{
				if(result == -2)
					req.setAttribute("message", "Username hoặc email đã tồn tại");
				else req.setAttribute("message", "Tạo mới người dùng không thành công");
				roledtos = roleservice.getAllRoles();
				req.setAttribute("roles", roledtos);
				req.getRequestDispatcher(Url.URL_USER_ADD).forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + Path.USER_INDEX);
			break;
		case Path.USER_EDIT:
			int id = Integer.parseInt(req.getParameter("id"));
			dto.setId(id);
			result = userservice.edit(dto);
			if(result <1)
			{
				req.setAttribute("message", "Chỉnh sửa người dùng không thành công");
				roledtos = roleservice.getAllRoles();
				req.setAttribute("roles", roledtos);
				req.getRequestDispatcher(Url.URL_USER_EDIT).forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + Path.USER_INDEX);
			break;
		}
	}
}
