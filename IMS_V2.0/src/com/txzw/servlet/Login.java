package com.txzw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.txzw.entity.Teacher;

import DAO.UserDao;
import DAO.user.UserDaoImp;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao u = new UserDaoImp();
		Teacher teacher = u.login(username, password);
		if (teacher != null) {
			HttpSession session = request.getSession();
			String adminName = teacher.getNickname();
			session.setAttribute("adminName", adminName);
			session.setAttribute("teacher", teacher);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			request.getSession().setAttribute("message", "用户名或密码不正确!");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
