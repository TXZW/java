<%@page import="com.txzw.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.txzw.entity.Student"%>
<%@page import="com.txzw.util.SysConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	margin: 0px auto;
	border: 1px solid #000;
}

td {
	margin: 0px auto;
	border: 1px solid #000;
	text-align: center;
}

p {
	margin: 0px auto;
	text-align: center;
}
</style>
<script type="text/javascript">
	function check() {
		var page = ${Page};
		var pageCount = ${pageCount};
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
	function deletee(b) {
		var thisTr = b.parentNode.parentNode;
		var td1 = thisTr.childNodes.item(0);
		var id = td1.innerText;
		document.getElementById("id").value = id;
		document.getElementById("flag").value = 'delete';
		document.getElementById("myForm").submit();
	}

	function upp(a) {
		var thisTr = a.parentNode.parentNode;
		//				for(var i = 0; i < thisTr.childNodes.length - 1; i++) {
		//					thisTr.childNodes.item(i).innerHTML = "<input type='text' value='" + thisTr.childNodes.item(i).textContent + "'>";
		//				}
		//thisTr.childNodes.item(0).innerHTML = "<input type='text' value='" + thisTr.childNodes.item(0).textContent + "'>";
		//thisTr.childNodes.item(1).innerHTML = "<input type='text' value='" + thisTr.childNodes.item(1).textContent + "'>";
		thisTr.childNodes.item(5).innerHTML = "<input type='text' value='"
				+ thisTr.childNodes.item(5).innerText + "'>";
		thisTr.childNodes.item(6).innerHTML = "<button onclick='confirm(this)'>确定</button>&emsp;<button onclick='cancell(this)'>取消</button>";
	}
	function cancell(a) {
		var thisTr = a.parentNode.parentNode;
		thisTr.childNodes.item(5).innerHTML = thisTr.childNodes.item(5).value;
		thisTr.childNodes.item(6).innerHTML = "<button onclick='upp(this)'>修改评语</button>&emsp;<button onclick='deletee(this)'>删除</button>";
	}

	function confirm(a) {
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
	}
</script>
</head>
<body onload="check()">
	<c:if test="${studentList==null}">
		<c:if test="${sessionScope.adminName!=null}">
			<p>${sessionScope.adminName},欢迎使用学生信息管理系统</p>
		</c:if>
	</c:if>
	<c:if test="${studentList!=null}">
	<input type="hidden" id="page" value="${Page}" />
<input type="hidden" id="pageCount" value="${pageCount}" />
	<table cellpadding="5px" cellspacing="5px">
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
		List<Student> studentList=(List<Student>) request.getAttribute("studentList");
		Teacher teacher=(Teacher)session.getAttribute("teacher");
			for (Student student : studentList) {
						out.println("<tr><td>" + student.getStuID() + "</td><td>" + student.getStuName() + "</td><td>"
								+ student.getStuAge() + "</td><td>" + (student.getStuSex() == 1 ? "男" : "女")
								+ "</td><td>" + teacher.getNickname() + "</td><td>" + student.getComments()
								+ "</td><td><button onclick='upp(this)'>修改评语</button>&emsp;<button onclick='deletee(this)'>删除</button></td></tr>");
					}
		%>
		<td colspan="7"> 
		<button type="button" id="首页" onclick="window.location.href='${sessionScope.project}/StuServlet?Page=1'">首页</button>
		<button type="button" id="上一页" onclick="window.location.href='${sessionScope.project}/StuServlet?Page=${Page-1}'">上一页</button>
		<button type="button" id="下一页" onclick="window.location.href='${sessionScope.project}/StuServlet?Page=${Page+1}'">下一页</button>
		<button type="button" id="尾页" onclick="window.location.href='${sessionScope.project}/StuServlet?Page=${pageCount}'">尾页</button>
		<%-- <a href="student.jsp?Page=1">首页</a>
		<a	href="student.jsp?Page=<%=Page - 1%>">上一页</a> 
		<a	href="student.jsp?Page=<%=Page + 1%>">下一页</a> 
		<a	href="student.jsp?Page=<%=pageCount%>">尾页</a>  --%>
		<p>第${Page}页/共${pageCount}页</p>
		</td>
	</table>

	<form action="${sessionScope.project}/Manager" method="post" id="myForm">
		<input type="hidden" name="id" id="id" value="" /> <input
			type="hidden" name="flag" id="flag" value="" /> <input type="hidden"
			name="comment" id="comment" value="" />
	</form>
	</c:if>
</body>
</html>