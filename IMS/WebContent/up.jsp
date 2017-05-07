<%@page import="com.txzw.util.SysConstants"%>
<%@page import="com.txzw.util.Datas"%>
<%@page import="com.txzw.client.ClientBIZ"%>
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
	ClientBIZ clientBIZ = (ClientBIZ) session.getAttribute("clientBIZ");
	// 获得学员信息
	request.setCharacterEncoding("utf-8");
	String ids = (String) request.getAttribute("id");
	if (null != ids) {
		String comments = (String) request.getAttribute("comment");
		int id = Integer.parseInt(ids);
		// 调用客户端业务的修改方法,获取服务器返回信息
		Datas datas = clientBIZ.doUpdate(id, comments);
		// 判断服务器返回状态
		if (datas.getFlag().equals(SysConstants.SYS_UPDATE)) {
			System.out.println("修改成功!");
			System.out.println(comments);
			response.sendRedirect("student.jsp");
		} else {
			System.out.println("修改失败!");
			response.sendRedirect("student.jsp");
		}
	}

	%>
</body>
</html>