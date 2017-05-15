package com.txzw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.txzw.entity.Student;

import DAO.UserDao;
import DAO.user.UserDaoImp;

/**
 * Servlet implementation class delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ids = (String) request.getAttribute("id");
		if (null != ids) {
			int id = Integer.parseInt(ids);
			UserDao u = new UserDaoImp();
			Student student = new Student();
			student.setStuID(id);
			int i = u.delete(student);
			if (i > 0) {
				System.out.println("删除成功!");
				response.sendRedirect(request.getContextPath() + "/StuServlet");
			}
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
