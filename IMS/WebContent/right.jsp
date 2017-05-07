<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		if (null != session.getAttribute("adminName")) {
			String title = session.getAttribute("adminName").toString() + ",欢迎使用学生信息管理系统";
			out.println("<h1>" + title + "</h1>");
		} else {
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>