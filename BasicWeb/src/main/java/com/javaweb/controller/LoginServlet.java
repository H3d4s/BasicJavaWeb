package com.javaweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.database.UserDao;
import com.javaweb.model.SessionManager;
import com.javaweb.model.UserModel;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDao userDAO = new UserDao();
		UserModel userModel = userDAO.getUserByUsernameAndPassword(username, password);

		if (userModel != null) {
			SessionManager.createSession(request, userModel);
			if (userModel.getRole().equals("admin")) {
				response.sendRedirect("admin.jsp");
			} else {
				response.sendRedirect("user.jsp");
			}
		} else {

		}
	}

}

