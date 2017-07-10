<%@page import="com.txzw.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.txzw.entity.Student"%>
<%@page import="com.txzw.util.SysConstants"%>
<%@page import="com.txzw.util.Datas"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="admin" value="${sessionScope.adminName},你好" />
<c:set var="title" value="${sessionScope.adminName},欢迎使用学生信息管理系统" />
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

		$("a")
				.click(
						function() {
							if ($(this).hasClass("upp")) {
								obj1 = $(this).parent().parent().children()[5];
								obj2 = $(this).next(".deletee");
								$(obj1).html(
										"<input class='form-control' type='text' value='"
												+ $(obj1).text() + "'>");
								$(this).removeClass("upp");
								$(obj2).removeClass("deletee");
								$(this).addClass("confirmm");
								$(obj2).addClass("cancell");
								$(this).text("确定");
								$(obj2).text("取消");
							} else if ($(this).hasClass("deletee")) {
								obj1 = $(this).parent().parent().children()[0];
								$("#id").val($(obj1).text());
								$("#flag").val('delete');
								$("#myForm").submit();
							} else if ($(this).hasClass("cancell")) {
								window.location.replace("StuServlet");
							} else if ($(this).hasClass("confirmm")) {
								obj1 = $(this).parent().parent().children()[0];
								obj2 = $(this).parent().parent().children("input")[0];
								$("#id").val($(obj1).text());
								$("#flag").val('up');
								$("#comment").val($(obj1).val());
								$("#myForm").submit();
							}
						});
	});

	/* function cancell() {
		window.location.replace("StuServlet");
	}

	function confirmm(a) {
		var thisTr = a.parentNode.parentNode;
		var thisInput = thisTr.getElementsByTagName("input");
		var comments = thisInput.item(0).value;
		var td1 = thisTr.childNodes.item(0);
		var id = td1.innerText;
		//thisTr.childNodes.item(1).innerHTML = thisInput.item(1).value;
		//thisTr.childNodes.item(0).innerHTML = thisInput.item(0).value;
		document.getElementById("id").value = id;
		document.getElementById("flag").value = 'up';
		document.getElementById("comment").value = comments;
		document.getElementById("myForm").submit();
	} */
	function check() {
		var page = ${Page}
		;
		var pageCount = ${pageCount}
		;
		if (page == pageCount) {
			document.getElementById("首页").disabled = false;
			document.getElementById("上一页").disabled = false;
			document.getElementById("下一页").disabled = true;
			document.getElementById("尾页").disabled = true;
		} else if (page == 1) {
			document.getElementById("首页").disabled = true;
			document.getElementById("上一页").disabled = true;
			document.getElementById("下一页").disabled = false;
			document.getElementById("尾页").disabled = false;
		}
	}
</script>
</head>

<body onload="check()">
	<input type="hidden" id="page" value="${Page}" />
	<input type="hidden" id="pageCount" value="${pageCount}" />
	<%@ include file="head.html"%>
	<div class="pull-right col-xs-11">
		<table class="table table-striped">
			<tr>
				<th>编号</th>
				<th>学生姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>班主任</th>
				<th>评语</th>
				<th>操作</th>
			</tr>
			<%
				List<Student> studentList = (List<Student>) request.getAttribute("studentList");
				Teacher teacher = (Teacher) session.getAttribute("teacher");
				for (Student student : studentList) {
					out.println("<tr><td>" + student.getStuID() + "</td><td>" + student.getStuName() + "</td><td>"
							+ student.getStuAge() + "</td><td>" + (student.getStuSex() == 1 ? "男" : "女") + "</td><td>"
							+ teacher.getNickname() + "</td><td>" + student.getComments()
							+ "</td><td><a class='btn btn-default upp' >修改评语</a>&emsp;<a class='btn btn-default deletee' >删除</a></td></tr>");
				}
			%>
			<td colspan="7" class="text-center">
				<button class="btn btn-default" type="button" id="首页"
					onclick="window.location.href='${sessionScope.project}/StuServlet?Page=1'">首页</button>
				<button class="btn btn-default" type="button" id="上一页"
					onclick="window.location.href='${sessionScope.project}/StuServlet?Page=${Page-1}'">上一页</button>
				<button class="btn btn-default" type="button" id="下一页"
					onclick="window.location.href='${sessionScope.project}/StuServlet?Page=${Page+1}'">下一页</button>
				<button class="btn btn-default" type="button" id="尾页"
					onclick="window.location.href='${sessionScope.project}/StuServlet?Page=${pageCount}'">尾页</button>
				<%-- <a href="student.jsp?Page=1">首页</a>
		<a	href="student.jsp?Page=<%=Page - 1%>">上一页</a> 
		<a	href="student.jsp?Page=<%=Page + 1%>">下一页</a> 
		<a	href="student.jsp?Page=<%=pageCount%>">尾页</a>  --%>
				<p>第${Page}页/共${pageCount}页</p>
			</td>
		</table>
	</div>

	<form action="${sessionScope.project}/Manager" method="post"
		id="myForm">
		<input type="hidden" name="id" id="id" value="" /> <input
			type="hidden" name="flag" id="flag" value="" /> <input type="hidden"
			name="comment" id="comment" value="" />
	</form>
</body>

</html>
