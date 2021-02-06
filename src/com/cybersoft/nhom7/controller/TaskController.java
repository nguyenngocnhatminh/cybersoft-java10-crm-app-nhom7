package com.cybersoft.nhom7.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybersoft.nhom7.dto.StatusDto;
import com.cybersoft.nhom7.dto.TaskCategoryDto;
import com.cybersoft.nhom7.dto.TaskDto;
import com.cybersoft.nhom7.dto.UserDto;
import com.cybersoft.nhom7.dto.UserProjectDto;
import com.cybersoft.nhom7.service.StatusService;
import com.cybersoft.nhom7.service.TaskCategoryService;
import com.cybersoft.nhom7.service.TaskService;
import com.cybersoft.nhom7.service.UserProjectService;
import com.cybersoft.nhom7.util.Path;
import com.cybersoft.nhom7.util.Url;

@WebServlet(name = "taskController", urlPatterns = {Path.TASK_INDEX,Path.TASK_ADD,Path.TASK_EDIT,Path.TASK_DELETE,Path.TASK_USER})
public class TaskController extends HttpServlet {
	UserProjectService userservice;
	StatusService	statusservice;
	TaskCategoryService taskcategoryservice;
	TaskService taskservice;
	
	public TaskController()
	{
		userservice = new UserProjectService();
		statusservice = new StatusService();
		taskcategoryservice = new TaskCategoryService();
		taskservice = new TaskService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		int projectid;
		List<TaskCategoryDto> taskcategories;
		List<UserProjectDto> dtos;
		
		List<StatusDto> status;
		switch(action)
		{
		case Path.TASK_INDEX:
			projectid = Integer.parseInt(req.getParameter("projectid"));
			List<TaskDto> tasks = taskservice.getAllTaskByProjectId(projectid);
			status = statusservice.getAllStatus();
			String data = statusservice.getStatusDataToggle();
			req.setAttribute("statustoggledata", data);
			req.setAttribute("tasks", tasks);
			req.setAttribute("listStatus", status);
			req.setAttribute("projectid", projectid);
			req.getRequestDispatcher(Url.URL_TASK_INDEX).forward(req, resp);
			break;
		case Path.TASK_ADD:
			projectid = Integer.parseInt(req.getParameter("projectid"));
			taskcategories = taskcategoryservice.getAllTaskCategory();
			dtos = userservice.getAllUserProjectByProjectId(projectid);
			status = statusservice.getAllStatus();
			req.setAttribute("liststatus", status);
			req.setAttribute("categories", taskcategories);
			req.setAttribute("projectid", projectid);
			req.setAttribute("userprojects", dtos);
			req.setAttribute("projectname", dtos.get(0).getProjectname());
			req.getRequestDispatcher(Url.URL_TASK_ADD).forward(req, resp);
			break;
		case Path.TASK_EDIT:
			int id = Integer.parseInt(req.getParameter("id"));
			TaskDto task = taskservice.getTaskById(id);
			taskcategories = taskcategoryservice.getAllTaskCategory();
			dtos = userservice.getAllUserProjectByProjectId(task.getProjectid());
			status = statusservice.getAllStatus();
			req.setAttribute("task", task);
			req.setAttribute("liststatus", status);
			req.setAttribute("categories", taskcategories);
			req.setAttribute("projectid", task.getProjectid());
			req.setAttribute("userprojects", dtos);
			req.setAttribute("projectname", dtos.get(0).getProjectname());
			req.getRequestDispatcher(Url.URL_TASK_EDIT).forward(req, resp);
			break;
		case Path.TASK_DELETE:
			break;
		case Path.TASK_USER:
			HttpSession session = req.getSession();
			UserDto user = (UserDto) session.getAttribute("USER_LOGIN");
			List<TaskDto> taskdto = taskservice.getTaskByUserId(user.getId());
			req.setAttribute("task", taskdto);
			req.getRequestDispatcher(Url.URL_TASK_USER).forward(req, resp);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		TaskDto dto = new TaskDto();
		dto.setName(req.getParameter("name"));
		dto.setDescription(req.getParameter("description"));
		dto.setProjectid(Integer.parseInt(req.getParameter("projectid")));
		dto.setUserid(Integer.parseInt(req.getParameter("userid")));
		dto.setCategoryid(Integer.parseInt(req.getParameter("categoryid")));
		Date startdate = java.sql.Date.valueOf(req.getParameter("startdate"));
		Date enddate = java.sql.Date.valueOf(req.getParameter("enddate"));
		dto.setStartdate(startdate);
		dto.setEnddate(enddate);
		dto.setStatusid(Integer.parseInt(req.getParameter("statusid")));
		
		switch(action)
		{
		case Path.TASK_ADD:
			HttpSession session = req.getSession();
			UserDto user =(UserDto)session.getAttribute("USER_LOGIN");
			dto.setCreateuserid(user.getId());
			if(taskservice.save(dto) < 1)
			{
				req.setAttribute("message", "Thêm task không thành công");
				req.getRequestDispatcher(Url.URL_TASK_ADD).forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + Path.TASK_INDEX + "?projectid="+dto.getProjectid());
			break;
		case Path.TASK_EDIT:
			dto.setId(Integer.parseInt(req.getParameter("id")));
			if(taskservice.edit(dto)<1)
			{
				req.setAttribute("message", "Cập nhật task thất bại");
				req.getRequestDispatcher(Url.URL_TASK_EDIT).forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + Path.TASK_INDEX+ "?projectid="+dto.getProjectid());
			break;
		}
	}

}
