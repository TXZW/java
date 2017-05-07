<%@page import="com.txzw.util.SysConstants"%>
<%@page import="com.txzw.client.ClientBIZ"%>
<%@page import="com.txzw.util.Datas"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

</head>
<body>
	<%!ClientBIZ clientBIZ = new ClientBIZ();%>
	<%
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Datas datas = clientBIZ.doLogic(username, password);
		if (datas.getFlag().equals(SysConstants.SYS_SUCCESS)) {
			String name = datas.getTeacher().getNickname();
			session.setAttribute("adminName", name);
			session.setAttribute("clientBIZ", clientBIZ);
			session.setAttribute("teacher", datas.getTeacher());
			response.sendRedirect("success.jsp");
			//createStudentManageView(datas.getTeacher());
		} else {
			request.setAttribute("message", "用户名或密码输入错误,请重新输入!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	%>
</body>
</html>
<%
	if (null == session.getAttribute("adminName")) {
		response.sendRedirect("login.jsp");
	}
%>