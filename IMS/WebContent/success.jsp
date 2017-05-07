<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功</title>
<%
	if (null == session.getAttribute("adminName")) {
		response.sendRedirect("login.jsp");
	}
%>
</head>
<body>
	<h1>登陆成功,3秒之后跳转...</h1>
	<script type="text/javascript">
		setTimeout(function() {
			location.href="index.jsp";
		}, 3000);
	</script>
</body>
</html>