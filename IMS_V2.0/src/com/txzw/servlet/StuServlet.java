package com.txzw.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.txzw.entity.Student;
import com.txzw.entity.Teacher;
import com.txzw.util.SysConstants;
import com.txzw.util.Tools;

import DAO.UserDao;
import DAO.user.UserDaoImp;

/**
 * Servlet implementation class StuServlet
 */
@WebServlet("/StuServlet")
public class StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		UserDao u = new UserDaoImp();
		List<Student> studentList = u.catchStu(teacher.getID());
		int pageCount = 0;
		int Page = 1;
		int pageSize = Integer.parseInt(Tools.getValue(SysConstants.PAGE_SIZE));
		String tmp = request.getParameter("Page");
		if (tmp == null) {
			tmp = "1";
		}
		Page = Integer.parseInt(tmp);

		int row = studentList.size();
		pageCount = (row % pageSize == 0) ? row / pageSize : row / pageSize + 1;
		if (Page > pageCount) {
			Page = pageCount;
		} else if (Page < 1) {
			Page = 1;
		}

		List<Student> stl = new ArrayList<Student>();
		for (int i = pageSize * (Page - 1); i < pageSize * (Page) && i < row; i++) {
			if (null != studentList.get(i)) {
				stl.add(studentList.get(i));
			}
		}
		request.setAttribute("studentList", stl);
		request.setAttribute("Page", Page);
		request.setAttribute("pageCount", pageCount);
		request.getRequestDispatcher("right.jsp").forward(request, response);
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
