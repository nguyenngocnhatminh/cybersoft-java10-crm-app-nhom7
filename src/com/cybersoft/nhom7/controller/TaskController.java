package com.cybersoft.nhom7.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.nhom7.dto.UserProjectDto;
import com.cybersoft.nhom7.service.UserProjectService;
import com.cybersoft.nhom7.util.Path;
import com.cybersoft.nhom7.util.Url;

@WebServlet(name = "taskController", urlPatterns = {Path.TASK_INDEX,Path.TASK_ADD,Path.TASK_EDIT,Path.TASK_DELETE})
public class TaskController extends HttpServlet {
	UserProjectService service;
	
	public TaskController()
	{
		service = new UserProjectService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		int projectid;
		switch(action)
		{
		case Path.TASK_INDEX:
			 projectid = Integer.parseInt(req.getParameter("projectid"));
			req.setAttribute("projectid", projectid);
			req.getRequestDispatcher(Url.URL_TASK_INDEX).forward(req, resp);
			break;
		case Path.TASK_ADD:
			projectid = Integer.parseInt(req.getParameter("projectid"));
			List<UserProjectDto> dtos = service.getAllUserProjectByProjectId(projectid);
			req.setAttribute("projectid", projectid);
			req.setAttribute("userprojects", dtos);
			req.setAttribute("projectname", dtos.get(0).getProjectname());
			req.getRequestDispatcher(Url.URL_TASK_ADD).forward(req, resp);
			break;
		case Path.TASK_EDIT:
			req.getRequestDispatcher(Url.URL_TASK_EDIT).forward(req, resp);
			break;
		case Path.TASK_DELETE:
			break;
		}
	}

}
