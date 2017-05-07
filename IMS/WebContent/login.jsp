<%@page import="com.sun.org.apache.regexp.internal.REDebugCompiler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理系统</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

div {
	margin: 0px auto;
	width: 300px;
}

table {
	margin: 0px auto;
}

p {
	margin: 0px auto;
	color: red;
	text-align: center;
}

input {
	width: 150px;
}
</style>
<script language="javascript">
	function custom_close() {
		if (confirm("您确定要关闭本页吗？")){
			window.opener=null;
			window.open('','_self');
			window.close();
			}
	}
</script>
</head>
<body>
	<div>
		<h2 style="text-align: center;">欢迎使用学生信息管理系统</h2>
		<%
			Object msg = request.getAttribute("message");
			if (msg != null) {
				out.println("<p>" + msg.toString() + "</p>");
			}
		%>
		<form action="PageClient.jsp" method="post">
			<table>
				<tr>
					<td style="text-align: right;"><label for="username">用户名:</label></td>
					<td><input type="text" name="username" id="username" value=""></td>
				</tr>
				<tr>
					<td style="text-align: right;"><label for="password">密&emsp;码:</label></td>
					<td><input type="password" name="password" id="password"
						value=""></td>
				</tr>
				<tr>
					<td style="text-align: center;" colspan="2"><button
							type="submit">登录</button>
						<button type="button" onclick="custom_close()">关闭</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>