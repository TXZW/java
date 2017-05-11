<%@page import="com.txzw.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.txzw.entity.Student"%>
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
<style type="text/css">
table, td {
	margin: 0px auto;
	border: 1px solid #000;
}

p {
	margin: 0px auto;
	text-align: center;
}
</style>
<script type="text/javascript">
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
		thisTr.childNodes.item(6).innerHTML = "<button onclick='confirm(this)'>确定</button>&emsp;<button onclick='javascript:location.href=\"student.jsp\"'>取消</button>";
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

	function up(b) {
		var td = b.parentNode;
		var tr = td.parentNode;
		var td1 = tr.firstChild;
		var id = td1.innerText;

	}
</script>

</head>

<body>
	<%!List<Student> studentList = null;
	public static final int PAGESIZE = 10;
	int pageCount = 0;
	int Page = 1;%>
	<%
		String tmp = request.getParameter("Page");
		if (tmp == null) {
			tmp = "1";
		}
		Page = Integer.parseInt(tmp);
		ClientBIZ clientBIZ = (ClientBIZ) session.getAttribute("clientBIZ");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		if (null != clientBIZ) {
			// 调用客户端业务查询方法,获取服务器返回信息
			Datas datas = clientBIZ.doFind(teacher.getID());
			pageCount = datas.getPageCount(PAGESIZE);
			if (Page > pageCount) {
				Page = pageCount;
			} else if (Page == 0) {
				Page = 1;
			}
			// 判断服务器返回状态
			if (SysConstants.SYS_FIND.equals(datas.getFlag())) {
				// 获取学员集合
				List<Student> studentList = datas.getStudentList(Page);
				// 输出显示
	%>
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
			for (Student student : studentList) {
						out.println("<tr><td>" + student.getStuID() + "</td><td>" + student.getStuName() + "</td><td>"
								+ student.getStuAge() + "</td><td>" + (student.getStuSex() == 1 ? "男" : "女")
								+ "</td><td>" + teacher.getNickname() + "</td><td>" + student.getComments()
								+ "</td><td><button onclick='upp(this)'>修改评语</button>&emsp;<button onclick='deletee(this)'>删除</button></td></tr>");
					}
		session.setAttribute("clientBIZ", clientBIZ);
		%>
	</table>
	<p>
		<a href="student.jsp?Page=1">首页</a> <a
			href="student.jsp?Page=<%=Page - 1%>">上一页</a> <a
			href="student.jsp?Page=<%=Page + 1%>">下一页</a> <a
			href="student.jsp?Page=<%=pageCount%>">尾页</a> 第<%=Page%>页/共<%=pageCount%>页
	</p>
	<%
		} else {
				out.println("查询失败!");
			}
		}
	%>

	<form action="student.jsp" method="post" id="myForm">
		<input type="hidden" name="id" id="id" value="" /> <input
			type="hidden" name="flag" id="flag" value="" /> <input type="hidden"
			name="comment" id="comment" value="" />
	</form>
	<%
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = (String) request.getParameter("flag");
		String id = (String) request.getParameter("id");
		String comment = (String) request.getParameter("comment");
		if (null != flag) {
			switch (flag) {
			case "delete":
				request.setAttribute("id", id);
				request.getRequestDispatcher("delete.jsp").forward(request, response);
				break;
			case "up":
				request.setAttribute("id", id);
				request.setAttribute("comment", comment);
				request.getRequestDispatcher("up.jsp").forward(request, response);
				break;
			default:
			}
		}
	%>
</body>

</html>
<%
	if (null == session.getAttribute("adminName")) {
		response.sendRedirect("login.jsp");
	}
%>

