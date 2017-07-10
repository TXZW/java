<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:choose>
	<c:when test="${sessionScope.adminName!=null}">
		<c:set var="admin" value="${sessionScope.adminName},你好" />
		<c:set var="title" value="${sessionScope.adminName},欢迎使用学生信息管理系统" />
	</c:when>
	<c:otherwise>
		<c:redirect url="login.jsp" />
	</c:otherwise>
</c:choose>
<title>${title}</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#exit").click(function() {
			if (confirm("是否注销账户?")) {
				location.href = "Logout";
			}
		});
	});
</script>
<body>
	<%-- <%!String admin = null;
	String title = null;
	String name = null;%>
<%
	if (null != session.getAttribute("adminName")) {
		name = session.getAttribute("adminName").toString();
		title = name + ",欢迎使用学生信息管理系统";
		//admin = name + ",你好";
%><title><%=title%></title>
<%
	} else {
		response.sendRedirect("login.jsp");
	}
%> --%>
	<%@ include file="head.html"%>
	<div class="pull-right col-xs-11 text-center" style="height: 80%;">
		${sessionScope.adminName},欢迎使用学生信息管理系统</div>


</body>