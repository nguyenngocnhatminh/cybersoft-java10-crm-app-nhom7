package com.cybersoft.nhom7.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.nhom7.util.Path;
import com.cybersoft.nhom7.util.Url;

@WebServlet(name = "errorController", urlPatterns = {Path.ERROR_403,Path.ERROR_404})
public class ErrorController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch(action)
		{
		case Path.ERROR_403:
			req.getRequestDispatcher(Url.URL_403).forward(req, resp);
			break;
		case Path.ERROR_404:
			req.getRequestDispatcher(Url.URL_404).forward(req, resp);
			break;
		}
	}

}
