package com.cybersoft.nhom7.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet(name = "profileController", urlPatterns = { Path.PROFILE, Path.PROFILE_EDIT })
public class ProfileController extends HttpServlet {
	RoleService roleservice;
	UserService userservice;

	public ProfileController() {
		roleservice = new RoleService();
		userservice = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getServletPath();
		List<RoleDto> roledtos;

		switch (action) {
		case Path.PROFILE:
			req.getRequestDispatcher(Url.URL_USER_PROFILE).forward(req, resp);
			break;
		case Path.PROFILE_EDIT:
			roledtos = roleservice.getAllRoles();
			req.setAttribute("roles", roledtos);
			req.getRequestDispatcher(Url.URL_USER_PROFILE_EDIT).forward(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getServletPath();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		int roleid = Integer.parseInt(req.getParameter("roleid"));
		
		List<RoleDto> roledtos;
		UserDto dto = new UserDto(username,password,email,address,fullname,phone,roleid);
		switch (action) {
		case Path.PROFILE_EDIT:
			int id = Integer.parseInt(req.getParameter("id"));
			dto.setId(id);
			int result = userservice.edit(dto);
			if (result < 1) {
				req.setAttribute("message", "Chỉnh sửa người dùng không thành công");
				roledtos = roleservice.getAllRoles();
				req.setAttribute("roles", roledtos);
				req.getRequestDispatcher(Url.URL_USER_PROFILE_EDIT).forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + Path.PROFILE);
			break;
		}
	}
}
