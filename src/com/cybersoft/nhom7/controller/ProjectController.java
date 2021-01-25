package com.cybersoft.nhom7.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.nhom7.util.Path;
import com.cybersoft.nhom7.util.Url;

@WebServlet(name="projectController",urlPatterns = {Path.PROJECT_INDEX,Path.PROJECT_ADD,Path.PROJECT_EDIT,Path.PROJECT_DELETE})
public class ProjectController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getServletPath();
		
		switch(action)
		{
		case Path.PROJECT_INDEX:
			req.getRequestDispatcher(Url.URL_PROJECT_INDEX).forward(req, resp);
			break;
		case Path.PROJECT_ADD:
			req.getRequestDispatcher(Url.URL_PROJECT_ADD).forward(req, resp);
			break;
		case Path.PROJECT_EDIT:
			req.getRequestDispatcher(Url.URL_PROJECT_EDIT).forward(req, resp);
			break;
		case Path.PROJECT_DELETE:
			resp.sendRedirect(req.getContextPath() + Path.PROJECT_INDEX);
			break;
		}
	}

}
