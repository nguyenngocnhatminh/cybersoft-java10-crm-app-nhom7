package com.cybersoft.nhom7.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybersoft.nhom7.dto.ProjectDto;
import com.cybersoft.nhom7.dto.UserDto;
import com.cybersoft.nhom7.dto.UserProjectDto;
import com.cybersoft.nhom7.service.ProjectService;
import com.cybersoft.nhom7.service.UserProjectService;
import com.cybersoft.nhom7.util.Path;
import com.cybersoft.nhom7.util.Url;

@WebServlet(name = "projectController", urlPatterns = { Path.PROJECT_INDEX, Path.PROJECT_ADD, Path.PROJECT_EDIT,
		Path.PROJECT_DELETE, Path.PROJECT_USER })
public class ProjectController extends HttpServlet {

	ProjectService service;
	UserProjectService userprojectservice;

	public ProjectController() {
		service = new ProjectService();
		userprojectservice = new UserProjectService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getServletPath();
		int id;
		HttpSession session = req.getSession();

		switch (action) {
		case Path.PROJECT_INDEX:
			UserDto user = (UserDto) session.getAttribute("USER_LOGIN");
			List<ProjectDto> dtos;
			if(user.getRolename().equals("ROLE_ADMIN"))
				dtos = service.getAllProjects();
			else
				dtos = service.getAllProjectsByUser(user.getId());
			req.setAttribute("projects", dtos);
			req.getRequestDispatcher(Url.URL_PROJECT_INDEX).forward(req, resp);
			break;
		case Path.PROJECT_ADD:
			req.getRequestDispatcher(Url.URL_PROJECT_ADD).forward(req, resp);
			break;
		case Path.PROJECT_EDIT:
			id = Integer.parseInt(req.getParameter("id"));
			ProjectDto dto = service.getProjectByID(id);
			req.setAttribute("project", dto);
			req.getRequestDispatcher(Url.URL_PROJECT_EDIT).forward(req, resp);
			break;
		case Path.PROJECT_DELETE:
			id = Integer.parseInt(req.getParameter("id"));
			if (service.delete(id) < 1)
				;
			req.setAttribute("message", "Xóa không thành công");
			resp.sendRedirect(req.getContextPath() + Path.PROJECT_INDEX);
			break;
		case Path.PROJECT_USER:
			id = Integer.parseInt(req.getParameter("id"));
			List<UserProjectDto> listuser = userprojectservice.getAllUserProjectByProjectId(id);
			req.setAttribute("userprojects", listuser);
			req.setAttribute("projectId", id);
			req.getRequestDispatcher(Url.URL_PROJECT_USER).forward(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getServletPath();
		if (action == Path.PROJECT_ADD || action == Path.PROJECT_EDIT) {
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			HttpSession session = req.getSession();
			UserDto user = (UserDto) session.getAttribute("USER_LOGIN");
			ProjectDto dto = new ProjectDto(name, description, user.getId());
			Date startdate = java.sql.Date.valueOf(req.getParameter("startdate"));
			Date enddate = java.sql.Date.valueOf(req.getParameter("enddate"));
			dto.setStartdate(startdate);
			dto.setEnddate(enddate);
			switch (action) {
			case Path.PROJECT_ADD:
				if (service.save(dto) < 1) {
					req.setAttribute("message", "Thêm mới không thành công");
					req.getRequestDispatcher(Url.URL_PROJECT_ADD).forward(req, resp);
					return;
				}
				resp.sendRedirect(req.getContextPath() + Path.PROJECT_INDEX);
				break;
			case Path.PROJECT_EDIT:
				int id = Integer.parseInt(req.getParameter("id"));
				dto.setId(id);
				if (service.edit(dto) < 1) {
					req.setAttribute("message", "Chỉnh sửa không thành công");
					req.getRequestDispatcher(Url.URL_PROJECT_EDIT).forward(req, resp);
					return;
				}
				resp.sendRedirect(req.getContextPath() + Path.PROJECT_INDEX);

				break;
			}
			return;
		}
		
		//projectuser
		switch(action)
		{
		case Path.PROJECT_USER:
			int projectid = Integer.parseInt(req.getParameter("projectId"));
			String[] userids = req.getParameterValues("check");
			if(userids == null)
			{
				if(userprojectservice.delete(projectid) < 1)
				{
					req.setAttribute("message", "Lưu thành viên không thành công");
					List<UserProjectDto> listuser = userprojectservice.getAllUserProjectByProjectId(projectid);
					req.setAttribute("userprojects", listuser);
					req.setAttribute("projectId", projectid);
					req.getRequestDispatcher(Url.URL_PROJECT_USER).forward(req, resp);
					return;
				}
				resp.sendRedirect(req.getContextPath() + Path.PROJECT_INDEX);
				return;
			}
			String[] joindates = new String[userids.length];
			String[] roles = new String[userids.length];
			for(int i  = 0 ;i <userids.length ; i++)
			{
				 joindates[i] = req.getParameter("joindate"+userids[i]);
				 roles[i] = req.getParameter("role"+userids[i]);
			}
			List<UserProjectDto> dtos = userprojectservice.ParseToUserProjectDto(userids, projectid, joindates, roles);
			if(userprojectservice.save(dtos) < 1 )
			{
				req.setAttribute("message", "Lưu thành viên không thành công");
				List<UserProjectDto> listuser = userprojectservice.getAllUserProjectByProjectId(projectid);
				req.setAttribute("userprojects", listuser);
				req.setAttribute("projectId", projectid);
				req.getRequestDispatcher(Url.URL_PROJECT_USER).forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + Path.PROJECT_INDEX);
			break;
		}
		
	}

}
