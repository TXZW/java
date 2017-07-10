<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理系统</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"
	type="text/javascript"></script>
</style>
<script language="javascript">
	function custom_close() {
		if (confirm("您确定要关闭本页吗？")) {
			window.opener = null;
			window.open('', '_self');
			window.close();
		}
	}
</script>
</head>
<body>
	<div>
		<h2 style="text-align: center;">欢迎使用学生信息管理系统</h2>
		<c:if test="${sessionScope.message!=null}">
			<p>${sessionScope.message}</p>
			<%
				session.invalidate();
			%>
		</c:if>
		<%-- <%
			Object msg = request.getAttribute("message");
			if (msg != null) {
				out.println("<p>" + msg.toString() + "</p>");
			}
		%> --%>
		<div style="padding: 100px 100px 10px;width: 500px;" class="center-block">
			<form action="${sessionScope.project }/Login" method="post"
				class="bs-example bs-example-form text-center" role="form">

				<div class="input-group">
					<span class="input-group-addon">用户名:</span> <input type="text"
						name="username" id="username" class="form-control" value="">
				</div>
				<div class="input-group">
					<span class="input-group-addon">用户名:</span> <input type="password"
						name="password" id="password" class="form-control" value="">
				</div>
				<button class="btn btn-default" type="submit">登录</button>
				<button class="btn btn-default" type="button"
					onclick="custom_close()">关闭</button>
			</form>
		</div>
	</div>
</body>
</html>