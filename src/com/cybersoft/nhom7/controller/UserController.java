package com.cybersoft.nhom7.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.nhom7.util.Path;
import com.cybersoft.nhom7.util.Url;

@WebServlet(name = "userController", urlPatterns = {Path.USER_INDEX,Path.USER_ADD,Path.USER_EDIT,Path.USER_DELETE})
public class UserController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch(action)
		{
		case Path.USER_INDEX:
			req.getRequestDispatcher(Url.URL_USER_INDEX).forward(req, resp);
			break;
		case Path.USER_ADD:
			req.getRequestDispatcher(Url.URL_USER_ADD).forward(req, resp);;
			break;
		case Path.USER_EDIT:
			break;
		case Path.USER_DELETE:
			break;
		}
	}
}
