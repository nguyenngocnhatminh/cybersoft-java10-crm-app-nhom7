package com.cybersoft.nhom7.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.nhom7.dto.RoleDto;
import com.cybersoft.nhom7.service.RoleService;
import com.cybersoft.nhom7.util.Path;
import com.cybersoft.nhom7.util.Url;

@WebServlet(name = "roleServlet", urlPatterns = {Path.ROLE_INDEX,Path.ROLE_ADD,Path.ROLE_EDIT,Path.ROLE_DELETE})
public class RoleController extends HttpServlet{
	RoleService service;
	


	public RoleController() {
		service = new RoleService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		int id;
		switch(action)
		{
		case Path.ROLE_INDEX:
			List<RoleDto> dtos = service.getAllRoles();
			req.setAttribute("roles", dtos);
			req.getRequestDispatcher(Url.URL_ROLE_INDEX).forward(req, resp);;
			break;
		case Path.ROLE_ADD:
			req.getRequestDispatcher(Url.URL_ROLE_ADD).forward(req, resp);;
			break;
		case Path.ROLE_EDIT:
			id = Integer.parseInt(req.getParameter("id"));
			RoleDto dto = service.getRoleById(id);
			req.setAttribute("role", dto);
			req.getRequestDispatcher(Url.URL_ROLE_EDIT).forward(req, resp);;
			break;
		case Path.ROLE_DELETE:
			 id = Integer.parseInt(req.getParameter("id"));
			if(service.delete(id) < 1)
			{
				req.setAttribute("message", "Xóa không thành công");
			}
			resp.sendRedirect(req.getContextPath()+Path.ROLE_INDEX);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		String roleName = req.getParameter("rolename");
		String roleDescription = req.getParameter("description");
		RoleDto dto = new RoleDto(roleName,roleDescription);
		switch(action)
		{
		case Path.ROLE_ADD:
			
			if(service.save(dto) > 0)
			{
				resp.sendRedirect(req.getContextPath()+Path.ROLE_INDEX);
				return;
			}
			req.setAttribute("message", "Tạo mới không thành công");
			req.getRequestDispatcher(Url.URL_ROLE_ADD).forward(req, resp);
			break;
		case Path.ROLE_EDIT:
			int id = Integer.parseInt(req.getParameter("id"));
			dto.setId(id);
			if(service.edit(dto) > 0)
			{
				resp.sendRedirect(req.getContextPath()+Path.ROLE_INDEX);
				return;
			}
			req.setAttribute("message", "Sửa không thành công");
			req.setAttribute("role", dto);
			req.getRequestDispatcher(Url.URL_ROLE_EDIT).forward(req, resp);
			break;
		}
	}
	
}
