<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%!String admin = null;
	String title = null;
	String name = null;%>
<%
	if (null != session.getAttribute("adminName")) {
		name = session.getAttribute("adminName").toString();
		title = name + ",欢迎使用学生信息管理系统";
		admin = name + ",你好";
%><title><%=title%></title>
<%
	} else {
		response.sendRedirect("login.jsp");
	}
%>
<script type="text/javascript">
	function exit() {
		if (confirm("是否注销账户?")) {
			location.href = "exit.jsp";
		}
	}
</script>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

html, body {
	height: 100%;
	/* overflow: hidden; */
}
p,h1{
text-align: center;
margin: 0px auto;
}
div {
	border: 1px solid #000;
}

div#top {
	height: 100px;
	width: 99.9%;
}

div#left {
	height: 100%;
	border-top: none;
	width: 10%;
	display: inline-block;
	float:left;
}

div#right {
	height: 100%;
	width: 89.8%;
	border-top: none;
	border-left: none;
	display: inline-block;
}

iframe {
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>
	<div id="top">
	<p><h1>欢迎使用学生信息管理系统</h1></p>
		<span><%=admin%></span>
		<button type="button" onclick="exit()">注销</button>
	</div>
	<div id="left">
		<p>
			<a href="student.jsp" target="rightOP">管理学生</a>
		</p>
	</div>
	<div id="right">
		<iframe name="rightOP" src="right.jsp"><%=title%></iframe>
	</div>
</body>
</html>